package com.ontop.martinez.interview.user.infraestructure.output.persistence;

import com.ontop.martinez.interview.user.application.ports.output.UserOutputPort;
import com.ontop.martinez.interview.user.domain.model.User;
import com.ontop.martinez.interview.user.infraestructure.output.persistence.mapper.UserPersistenceMapper;
import com.ontop.martinez.interview.user.infraestructure.output.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class UserPersistenceAdapter implements UserOutputPort {

    private final UserRepository userRepository;

    private final UserPersistenceMapper userPersistenceMapper;
    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userPersistenceMapper.userEntityToUser(userRepository.findById(id).get()));
    }
}
