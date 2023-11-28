package com.ontop.martinez.interview.user.domain.services;

import com.ontop.martinez.interview.user.application.ports.input.GetDefaultSourceUserUseCase;
import com.ontop.martinez.interview.user.application.ports.input.GetUserByIdUseCase;
import com.ontop.martinez.interview.user.application.ports.output.UserOutputPort;
import com.ontop.martinez.interview.user.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements GetDefaultSourceUserUseCase, GetUserByIdUseCase {

    private final UserOutputPort userOutputPort;

    @Override
    public User getDefaultAccount() {
        Optional<User> defaultUser = userOutputPort.getUserById(1L);
        if(defaultUser.isEmpty()){
            throw new RuntimeException("error no default user config");
        }
        return userOutputPort.getUserById(1L).get();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userOutputPort.getUserById(id);
    }
}
