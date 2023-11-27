package com.ontop.martinez.interview.transaction.domain.model;

import com.ontop.martinez.interview.account.domain.model.Account;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    private Long id;
    private Long timestamp;
    private Account destination;
    private Account source;
    private Double amount;
    private Double fee;
    private Double totalAmount;
    private TransactionStatus status;

}
