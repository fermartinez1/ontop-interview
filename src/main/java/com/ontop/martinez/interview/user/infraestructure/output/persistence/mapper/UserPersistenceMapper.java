package com.ontop.martinez.interview.user.infraestructure.output.persistence.mapper;

import com.ontop.martinez.interview.company.domain.model.Company;
import com.ontop.martinez.interview.company.infrastructure.persistence.entities.CompanyEntity;
import com.ontop.martinez.interview.person.domain.model.Person;
import com.ontop.martinez.interview.person.infrastructure.persistence.models.PersonEntity;
import com.ontop.martinez.interview.user.domain.model.User;
import com.ontop.martinez.interview.user.infraestructure.output.persistence.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

   @SubclassMapping(source = CompanyEntity.class, target = Company.class)
   @SubclassMapping(source = PersonEntity.class, target = Person.class)
   User userEntityToUser(UserEntity userEntity);

   @SubclassMapping(source = Company.class, target = CompanyEntity.class)
   @SubclassMapping(source = Person.class, target = PersonEntity.class)
   UserEntity userToUserEntity(User user);
}
