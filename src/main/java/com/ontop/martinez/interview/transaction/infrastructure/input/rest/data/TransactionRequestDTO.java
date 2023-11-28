package com.ontop.martinez.interview.transaction.infrastructure.input.rest.data;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDTO {

    private String accountNumber;
    private BigDecimal amount;

}
