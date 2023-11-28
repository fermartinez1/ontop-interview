package com.ontop.martinez.interview.account.application.ports.input;

import com.ontop.martinez.interview.account.domain.model.Account;

import java.util.Optional;

public interface GetAccountByNumberUseCase {

    Optional<Account> getAccountByNumber(String accountNumber);
}
