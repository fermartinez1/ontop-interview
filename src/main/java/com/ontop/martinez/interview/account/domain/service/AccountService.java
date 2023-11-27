package com.ontop.martinez.interview.account.domain.service;

import com.ontop.martinez.interview.account.application.ports.input.GetAccountByNumberUseCase;
import com.ontop.martinez.interview.account.application.ports.input.GetDefaultAccountUseCase;
import com.ontop.martinez.interview.account.application.ports.output.AccountOutputPort;
import com.ontop.martinez.interview.account.domain.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService implements GetDefaultAccountUseCase, GetAccountByNumberUseCase {

    private final AccountOutputPort accountOutputPort;

    @Override
    public Account getDefaultSourceAccount() {
        Optional<Account> defaultAccount = accountOutputPort.getAccountByNumber(123L);
        if(defaultAccount.isEmpty()){
            throw new RuntimeException("error no default account config");
        }
        return defaultAccount.get();
    }

    @Override
    public Optional<Account> getAccountByNumber(Long accountNumber) {
        return accountOutputPort.getAccountByNumber(accountNumber);
    }
}
