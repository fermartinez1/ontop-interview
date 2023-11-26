package com.ontop.martinez.interview.transactions.domain.service;

import com.ontop.martinez.interview.transactions.application.ports.input.CreateTransactionUseCase;
import com.ontop.martinez.interview.transactions.application.ports.output.PaymentTransactionOutputPort;
import com.ontop.martinez.interview.transactions.application.ports.output.TransactionOutputPort;
import com.ontop.martinez.interview.transactions.application.ports.output.WalletTransactionOutputPort;
import com.ontop.martinez.interview.transactions.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService implements CreateTransactionUseCase {

    private final TransactionOutputPort transactionOutputPort;

    private final PaymentTransactionOutputPort paymentTransactionOutputPort;

    private final WalletTransactionOutputPort walletTransactionOutputPort;
    @Override
    public Transaction createTransaction(Transaction transaction) {
        transaction.setTimestamp(System.currentTimeMillis());
        transactionOutputPort.saveTransaction(transaction);
        return transaction;
    }
}
