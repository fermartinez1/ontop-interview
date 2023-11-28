package com.ontop.martinez.interview.wallet.application.ports.output;

import java.math.BigDecimal;

public interface WalletOutputPort {
    Long createWalletTransaction(Long userId, BigDecimal amount);

    BigDecimal getWalletBalance(Long userId);
}
