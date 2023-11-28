package com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WalletTransactionResponseDTO {

    BigDecimal amount;
    @JsonProperty("wallet_transaction_id")
    Long walletTransactionId;
    @JsonProperty("user_id")
    Long userId;
}
