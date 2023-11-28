package com.ontop.martinez.interview.transaction.domain.model;

import com.ontop.martinez.interview.account.domain.model.Account;
import lombok.*;

import java.math.BigDecimal;

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
    private BigDecimal amount;
    private BigDecimal fee;
    private BigDecimal totalAmount;
    private TransactionStatus status;
    private String walletTransactionId;
    private String paymentProviderTransactionId;

}
