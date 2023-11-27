package com.ontop.martinez.interview.account.infrastructure.output.persistence;

import com.ontop.martinez.interview.account.application.ports.output.AccountOutputPort;
import com.ontop.martinez.interview.account.domain.model.Account;
import com.ontop.martinez.interview.account.infrastructure.output.persistence.mappers.AccountPersistenceMapper;
import com.ontop.martinez.interview.account.infrastructure.output.persistence.models.AccountEntity;
import com.ontop.martinez.interview.account.infrastructure.output.persistence.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class AccountPersistenceAdapter implements AccountOutputPort {

    private final AccountRepository accountRepository;
    private final AccountPersistenceMapper accountPersistenceMapper;
    @Override
    public Optional<Account> getAccountByNumber(Long accountNumber) {
        Optional<AccountEntity> account = accountRepository.findById(accountNumber);
        if(account.isEmpty()){
            return Optional.empty();
        }
        return Optional.ofNullable(accountPersistenceMapper.accountEntityToAccount(account.get()));
    }
}
