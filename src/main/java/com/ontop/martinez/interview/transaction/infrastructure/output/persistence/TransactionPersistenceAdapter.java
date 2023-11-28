package com.ontop.martinez.interview.transaction.infrastructure.output.persistence;

import com.ontop.martinez.interview.transaction.application.ports.output.TransactionOutputPort;
import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import com.ontop.martinez.interview.transaction.infrastructure.output.persistence.mappers.TransactionPersistenceMapper;
import com.ontop.martinez.interview.transaction.infrastructure.output.persistence.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransactionPersistenceAdapter implements TransactionOutputPort {

    private final TransactionRepository transactionRepository;

    private final TransactionPersistenceMapper transactionPersistenceMapper;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionPersistenceMapper.transactionEntityToTransaction(transactionRepository.save(transactionPersistenceMapper.toTransactionEntity(transaction)));
    }
}
