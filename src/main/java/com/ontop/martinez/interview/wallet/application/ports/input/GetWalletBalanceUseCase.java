package com.ontop.martinez.interview.wallet.application.ports.input;

import java.math.BigDecimal;

public interface GetWalletBalanceUseCase {

    BigDecimal getWalletBalance(Long userId);
}
