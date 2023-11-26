package com.ontop.martinez.interview.transactions.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    private Long id;
    private Long timestamp;
    private Long sourceAccountId;
    private Long accountNumber;
    private Double amount;

}
