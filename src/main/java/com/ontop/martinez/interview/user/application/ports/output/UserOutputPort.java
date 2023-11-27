package com.ontop.martinez.interview.user.application.ports.output;

import com.ontop.martinez.interview.user.domain.model.User;

import java.util.Optional;

public interface UserOutputPort {

    Optional<User> getUserById(Long id);
}
