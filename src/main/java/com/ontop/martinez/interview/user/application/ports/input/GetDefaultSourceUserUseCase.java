package com.ontop.martinez.interview.user.application.ports.input;

import com.ontop.martinez.interview.user.domain.model.User;

public interface GetDefaultSourceUserUseCase {

    User getDefaultAccount();
}
