package com.ontop.martinez.interview.company.infrastructure.persistence.mappers;

import com.ontop.martinez.interview.company.domain.model.Company;
import com.ontop.martinez.interview.company.infrastructure.persistence.entities.CompanyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyPersistenceMapper {

    Company companyEntityToCompany(CompanyEntity companyEntity);
}
