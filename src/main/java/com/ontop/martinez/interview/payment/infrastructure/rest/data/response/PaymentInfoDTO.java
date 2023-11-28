package com.ontop.martinez.interview.payment.infrastructure.rest.data.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentInfoDTO {

    private BigDecimal amount;
    private String id;
}
