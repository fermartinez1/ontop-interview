package com.ontop.martinez.interview.transactions.infrastructure.output.persistence;

import com.ontop.martinez.interview.transactions.application.ports.output.TransactionOutputPort;
import com.ontop.martinez.interview.transactions.domain.model.Transaction;
import com.ontop.martinez.interview.transactions.infrastructure.output.persistence.mappers.TransactionPersistenceMapper;
import com.ontop.martinez.interview.transactions.infrastructure.output.persistence.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransactionPersistenceAdapter implements TransactionOutputPort {

    private final TransactionRepository transactionRepository;

    private final TransactionPersistenceMapper transactionPersistenceMapper;

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transactionPersistenceMapper.toTransactionEntity(transaction));
    }
}
