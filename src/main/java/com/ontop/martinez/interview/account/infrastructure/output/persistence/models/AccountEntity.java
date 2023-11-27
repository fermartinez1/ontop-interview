package com.ontop.martinez.interview.account.infrastructure.output.persistence.models;

import com.ontop.martinez.interview.user.infraestructure.output.persistence.entities.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    @Id
    private Long accountNumber;
    private String currency;
    private Long routingNumber;
    private String bankName;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    UserEntity userEntity;
}
