package com.ontop.martinez.interview.user.application.ports.input;

import com.ontop.martinez.interview.user.domain.model.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface GetUserByIdUseCase {

    Optional<User> getUserById(Long id);
}
