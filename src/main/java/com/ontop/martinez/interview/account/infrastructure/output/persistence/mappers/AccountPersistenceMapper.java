package com.ontop.martinez.interview.account.infrastructure.output.persistence.mappers;

import com.ontop.martinez.interview.account.domain.model.Account;
import com.ontop.martinez.interview.account.infrastructure.output.persistence.models.AccountEntity;
import com.ontop.martinez.interview.company.infrastructure.persistence.mappers.CompanyPersistenceMapper;
import com.ontop.martinez.interview.user.infraestructure.output.persistence.mapper.UserPersistenceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {UserPersistenceMapper.class, CompanyPersistenceMapper.class})
public interface AccountPersistenceMapper {

    @Mapping(target = "user", source = "accountEntity.userEntity")
    Account accountEntityToAccount(AccountEntity accountEntity);
}
