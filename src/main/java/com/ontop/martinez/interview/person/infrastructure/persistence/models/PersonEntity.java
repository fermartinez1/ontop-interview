package com.ontop.martinez.interview.person.infrastructure.persistence.models;

import com.ontop.martinez.interview.user.infraestructure.output.persistence.entities.UserEntity;
import jakarta.persistence.Entity;
import lombok.*;


@Entity(name="persons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity extends UserEntity {

    private Long birthDate;
    private String lastname;
}
