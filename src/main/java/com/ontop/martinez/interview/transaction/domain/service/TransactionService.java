package com.ontop.martinez.interview.transaction.domain.service;

import com.ontop.martinez.interview.account.application.ports.input.GetAccountByNumberUseCase;
import com.ontop.martinez.interview.account.application.ports.input.GetDefaultAccountUseCase;
import com.ontop.martinez.interview.account.domain.model.Account;
import com.ontop.martinez.interview.transaction.application.ports.input.CreateTransactionUseCase;
import com.ontop.martinez.interview.transaction.application.ports.output.TransactionOutputPort;
import com.ontop.martinez.interview.transaction.domain.exception.AccountNotFoundException;
import com.ontop.martinez.interview.transaction.domain.exception.NotEnoughFundsException;
import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import com.ontop.martinez.interview.wallet.application.ports.input.GetWalletBalanceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService implements CreateTransactionUseCase {

    private final TransactionOutputPort transactionOutputPort;

    private final GetAccountByNumberUseCase getAccountByNumberUseCase;

    private final GetDefaultAccountUseCase getDefaultAccountUseCase;

    private final GetWalletBalanceUseCase getWalletBalanceUseCase;
    @Override
    public Transaction createTransaction(Long accountNumber, Double amount) {

        Transaction transaction = Transaction.builder()
                .timestamp(System.currentTimeMillis())
                .amount(amount)
                .build();

        Account source = getAccountByNumberUseCase.getAccountByNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Source account not found with number " + accountNumber));
        transaction.setSource(source);

        addFeeAndCalculateTotals(transaction);
        checkIfBalanceIsValid(transaction);


        Account account = getDefaultAccountUseCase.getDefaultSourceAccount();
        transaction.setDestination(account);

        transactionOutputPort.saveTransaction(transaction);
        return transaction;
    }

    private void checkIfBalanceIsValid(Transaction transaction){
        Double balance = getWalletBalanceUseCase.getWalletBalance(transaction.getSource().getUser().getId());
        if(balance.compareTo(transaction.getTotalAmount())<0){
            throw new NotEnoughFundsException("Transaction amount is higher than wallet fund");
        }
    }

    private void addFeeAndCalculateTotals(Transaction transaction){
        transaction.setFee(10d);
        transaction.setTotalAmount(transaction.getAmount()*1.10);
    }
}
