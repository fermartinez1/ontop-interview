package com.ontop.martinez.interview.user.infraestructure.output.persistence.entities;


import com.ontop.martinez.interview.account.infrastructure.output.persistence.models.AccountEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserEntity {

    @Id
    private Long id;
    private String name;
    @OneToMany
    private List<AccountEntity> accounts;

}
