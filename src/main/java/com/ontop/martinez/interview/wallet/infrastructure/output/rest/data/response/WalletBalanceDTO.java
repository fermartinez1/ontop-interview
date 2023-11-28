package com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WalletBalanceDTO {

    Long user_id;
    BigDecimal balance;
}
