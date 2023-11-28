package com.ontop.martinez.interview.wallet.domain.services;

import com.ontop.martinez.interview.wallet.application.ports.input.CreateWalletTopUpTransactionUseCase;
import com.ontop.martinez.interview.wallet.application.ports.input.CreateWalletWithdrawTransactionUseCase;
import com.ontop.martinez.interview.wallet.application.ports.input.GetWalletBalanceUseCase;
import com.ontop.martinez.interview.wallet.application.ports.output.WalletOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class WalletService implements GetWalletBalanceUseCase, CreateWalletTopUpTransactionUseCase, CreateWalletWithdrawTransactionUseCase {

    private final WalletOutputPort walletOutputPort;
    @Override
    public BigDecimal getWalletBalance(Long userId) {
        return walletOutputPort.getWalletBalance(userId);
    }

    @Override
    public Long createWalletTopUpTransaction(Long userId, BigDecimal amount) {
        return walletOutputPort.createWalletTransaction(userId, amount.negate());
    }

    @Override
    public Long createWalletWithdrawTransaction(Long userId, BigDecimal amount) {
        return walletOutputPort.createWalletTransaction(userId, amount);
    }
}
