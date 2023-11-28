package com.ontop.martinez.interview.wallet.application.ports.input;

import java.math.BigDecimal;

public interface CreateWalletWithdrawTransactionUseCase {

    Long createWalletWithdrawTransaction(Long userId, BigDecimal amount);
}
