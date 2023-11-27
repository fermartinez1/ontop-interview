package com.ontop.martinez.interview.transaction.infrastructure.input.rest.data;

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
