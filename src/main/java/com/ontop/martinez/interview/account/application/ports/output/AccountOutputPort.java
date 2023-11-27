package com.ontop.martinez.interview.account.application.ports.output;

import com.ontop.martinez.interview.account.domain.model.Account;

import java.util.Optional;

public interface AccountOutputPort {

    Optional<Account> getAccountByNumber(Long accountNumber);


}
