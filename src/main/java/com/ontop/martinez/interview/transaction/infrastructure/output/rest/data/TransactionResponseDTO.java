package com.ontop.martinez.interview.transaction.infrastructure.output.rest.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDTO {

    private Long id;
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private Long timestamp;
    private BigDecimal amount;
    private BigDecimal fee;
    private BigDecimal totalAmount;
    private String status;
    private String walletTransactionId;
    private String paymentProviderTransactionId;

}
