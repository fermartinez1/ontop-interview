package com.ontop.martinez.interview.company.infrastructure.persistence.entities;


import com.ontop.martinez.interview.user.infraestructure.output.persistence.entities.UserEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity extends UserEntity {

    private Long foundationDate;
}
