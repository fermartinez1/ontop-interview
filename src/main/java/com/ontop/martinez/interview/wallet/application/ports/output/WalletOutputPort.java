package com.ontop.martinez.interview.wallet.application.ports.output;

import com.ontop.martinez.interview.transaction.domain.model.Transaction;

public interface WalletOutputPort {
    void createWalletTransaction(Transaction transaction);

    Double getWalletBalance(Long userId);
}
