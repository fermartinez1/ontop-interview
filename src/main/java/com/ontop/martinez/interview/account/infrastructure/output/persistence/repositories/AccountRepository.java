package com.ontop.martinez.interview.account.infrastructure.output.persistence.repositories;

import com.ontop.martinez.interview.account.infrastructure.output.persistence.models.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {
}
