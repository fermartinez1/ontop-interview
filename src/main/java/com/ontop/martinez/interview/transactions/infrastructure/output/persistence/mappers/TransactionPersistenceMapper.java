package com.ontop.martinez.interview.transactions.infrastructure.output.persistence.mappers;

import com.ontop.martinez.interview.transactions.domain.model.Transaction;
import com.ontop.martinez.interview.transactions.infrastructure.output.persistence.models.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionPersistenceMapper {

    @Mapping(target = "amount", source = "transaction.amount")
    TransactionEntity toTransactionEntity(Transaction transaction);

    Transaction toTransaction(TransactionEntity transactionEntity);

}
