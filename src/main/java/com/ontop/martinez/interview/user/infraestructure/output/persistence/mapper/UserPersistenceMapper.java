package com.ontop.martinez.interview.user.infraestructure.output.persistence.mapper;

import com.ontop.martinez.interview.user.domain.model.User;
import com.ontop.martinez.interview.user.infraestructure.output.persistence.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

   User userEntityToUser(UserEntity userEntity);
}
