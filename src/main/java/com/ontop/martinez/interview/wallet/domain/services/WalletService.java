package com.ontop.martinez.interview.wallet.domain.services;

import com.ontop.martinez.interview.wallet.application.ports.input.GetWalletBalanceUseCase;
import com.ontop.martinez.interview.wallet.application.ports.output.WalletOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService implements GetWalletBalanceUseCase {

    private final WalletOutputPort walletOutputPort;
    @Override
    public Double getWalletBalance(Long userId) {
        return walletOutputPort.getWalletBalance(userId);
    }
}
