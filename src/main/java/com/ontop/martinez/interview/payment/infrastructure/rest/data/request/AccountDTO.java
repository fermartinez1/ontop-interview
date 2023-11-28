package com.ontop.martinez.interview.payment.infrastructure.rest.data.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

    private String accountNumber;
    private String currency;
    private String routingNumber;

}
