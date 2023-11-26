package com.ontop.martinez.interview.transactions.infrastructure.input.rest.entities;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDTO {

    private Long accountNumber;
    private Double amount;

}
