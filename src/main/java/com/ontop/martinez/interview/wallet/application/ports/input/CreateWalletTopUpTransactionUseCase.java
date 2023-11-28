package com.ontop.martinez.interview.wallet.application.ports.input;

import java.math.BigDecimal;

public interface CreateWalletTopUpTransactionUseCase {

    Long createWalletTopUpTransaction(Long userId, BigDecimal amount);
}
