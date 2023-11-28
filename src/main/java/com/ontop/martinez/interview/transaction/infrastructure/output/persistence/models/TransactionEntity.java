package com.ontop.martinez.interview.transaction.infrastructure.output.persistence.models;

import com.ontop.martinez.interview.account.infrastructure.output.persistence.models.AccountEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long timestamp;
    @ManyToOne
    private AccountEntity sourceAccount;
    @ManyToOne
    private AccountEntity destinationAccount;
    private BigDecimal amount;
}
