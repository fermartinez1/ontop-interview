package com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

    private Long accountNumber;
    private String currency;
    private Long routingNumber;

}
