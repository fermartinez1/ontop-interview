package com.ontop.martinez.interview.payment.domain.model;

import com.ontop.martinez.interview.account.domain.model.Account;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private BigDecimal amount;
    private Account source;
    private Account destination;
    private String status;
    private String paymentId;

}
