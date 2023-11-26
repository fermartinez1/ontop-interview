package com.ontop.martinez.interview.transactions.infrastructure.output.rest;

import com.ontop.martinez.interview.transactions.application.ports.output.WalletTransactionOutputPort;
import com.ontop.martinez.interview.transactions.domain.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class WalletAdapter implements WalletTransactionOutputPort {
    @Override
    public void createWalletTransaction(Transaction transaction) {

    }
}
