package com.ontop.martinez.interview.wallet.infrastructure.output.rest;

import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import com.ontop.martinez.interview.wallet.application.ports.output.WalletOutputPort;
import com.ontop.martinez.interview.wallet.infrastructure.output.rest.clients.WalletClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class WalletRestAdapter implements WalletOutputPort {

    private final WalletClient walletClient;
    @Override
    public void createWalletTransaction(Transaction transaction) {

    }

    @Override
    public Double getWalletBalance(Long userId) {
        return walletClient.getBalance(userId).getBalance();
    }
}
