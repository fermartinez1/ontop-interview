package com.ontop.martinez.interview.user.infraestructure.output.persistence.repositories;

import com.ontop.martinez.interview.user.infraestructure.output.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
