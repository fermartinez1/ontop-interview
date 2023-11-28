package com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class WalletTransactionRequestDTO {

    BigDecimal amount;
    @JsonProperty("user_id")
    Long userId;
}
