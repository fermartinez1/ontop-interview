package com.ontop.martinez.interview.transactions.infrastructure.output.persistence.repositories;

import com.ontop.martinez.interview.transactions.infrastructure.output.persistence.models.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
