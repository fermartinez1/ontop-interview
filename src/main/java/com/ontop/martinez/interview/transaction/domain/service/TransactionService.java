package com.ontop.martinez.interview.transaction.domain.service;

import com.ontop.martinez.interview.account.application.ports.input.GetAccountByNumberUseCase;
import com.ontop.martinez.interview.account.application.ports.input.GetDefaultAccountUseCase;
import com.ontop.martinez.interview.account.domain.model.Account;
import com.ontop.martinez.interview.payment.application.ports.input.CreatePaymentUseCase;
import com.ontop.martinez.interview.payment.domain.model.Payment;
import com.ontop.martinez.interview.transaction.application.ports.input.CreateTransactionUseCase;
import com.ontop.martinez.interview.transaction.application.ports.output.TransactionOutputPort;
import com.ontop.martinez.interview.transaction.domain.exception.AccountNotFoundException;
import com.ontop.martinez.interview.transaction.domain.exception.InsufficientFundsException;
import com.ontop.martinez.interview.payment.domain.exception.ProviderPaymentException;
import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import com.ontop.martinez.interview.transaction.domain.model.TransactionStatus;
import com.ontop.martinez.interview.wallet.application.ports.input.CreateWalletTopUpTransactionUseCase;
import com.ontop.martinez.interview.wallet.application.ports.input.CreateWalletWithdrawTransactionUseCase;
import com.ontop.martinez.interview.wallet.application.ports.input.GetWalletBalanceUseCase;
import com.ontop.martinez.interview.wallet.domain.exception.WalletTransactionException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService implements CreateTransactionUseCase {

    private final TransactionOutputPort transactionOutputPort;

    private final GetAccountByNumberUseCase getAccountByNumberUseCase;

    private final CreatePaymentUseCase createPaymentUseCase;

    private final GetDefaultAccountUseCase getDefaultAccountUseCase;

    private final GetWalletBalanceUseCase getWalletBalanceUseCase;

    private final CreateWalletTopUpTransactionUseCase createWalletTopUpTransactionUseCase;

    private final CreateWalletWithdrawTransactionUseCase createWalletWithdrawTransactionUseCase;
    @Override
    @Transactional
    public Transaction createTransaction(String accountNumber, BigDecimal amount) {

        Transaction transaction = checkIsValidAndCreateTransaction(accountNumber, amount);

        try {
            createWalletTopUpTransactionUseCase.createWalletTopUpTransaction(transaction.getDestination().getUser().getId(), transaction.getTotalAmount());
            Optional<Payment> result = createPaymentUseCase.createPaymentInProvider(transaction);
            transaction.setStatus(TransactionStatus.valueOfString(result.get().getStatus()));
        } catch (WalletTransactionException exception) {
            transaction.setStatus(TransactionStatus.FAILED_BY_WALLET);
            transactionOutputPort.saveTransaction(transaction);
            return transaction;
        } catch (ProviderPaymentException exception) {
            transaction.setStatus(TransactionStatus.FAILED_BY_PROVIDER);
            transactionOutputPort.saveTransaction(transaction);
            createWalletWithdrawTransactionUseCase.createWalletWithdrawTransaction(transaction.getDestination().getUser().getId(), transaction.getTotalAmount());
            return transaction;
        } catch (Exception exception) {
            transaction.setStatus(TransactionStatus.FAILED);
            transactionOutputPort.saveTransaction(transaction);
        }

        transactionOutputPort.saveTransaction(transaction);
        return transaction;
    }

    private Transaction checkIsValidAndCreateTransaction(String accountNumber, BigDecimal amount) {
        Transaction transaction = Transaction.builder()
                .timestamp(System.currentTimeMillis())
                .amount(amount)
                .build();

        Account destinationAccount = getAccountByNumberUseCase.getAccountByNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Destination account not found with number " + accountNumber));
        transaction.setDestination(destinationAccount);

        addFeeAndCalculateTotals(transaction);
        checkSufficientFunds(transaction);

        Account account = getDefaultAccountUseCase.getDefaultSourceAccount();
        transaction.setSource(account);

        transaction.setStatus(TransactionStatus.CREATED);
        transactionOutputPort.saveTransaction(transaction);
        return transaction;
    }

    private void checkSufficientFunds(Transaction transaction){
        BigDecimal balance = getWalletBalanceUseCase.getWalletBalance(transaction.getDestination().getUser().getId());
        if(balance.compareTo(transaction.getTotalAmount())<0){
            throw new InsufficientFundsException("Transaction amount is higher than wallet funds");
        }
    }

    private void addFeeAndCalculateTotals(Transaction transaction){
        transaction.setFee(BigDecimal.valueOf(10));
        transaction.setTotalAmount(transaction.getAmount().multiply(BigDecimal.valueOf(1.10)));
    }
}
