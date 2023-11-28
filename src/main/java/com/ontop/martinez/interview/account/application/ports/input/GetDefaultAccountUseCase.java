package com.ontop.martinez.interview.account.application.ports.input;

import com.ontop.martinez.interview.account.domain.model.Account;
public interface GetDefaultAccountUseCase {

    Account getDefaultSourceAccount();
}
