package com.ontop.martinez.interview.transactions.application.ports.output;

import com.ontop.martinez.interview.transactions.domain.model.Transaction;

public interface WalletTransactionOutputPort {
    void createWalletTransaction(Transaction transaction);
}
