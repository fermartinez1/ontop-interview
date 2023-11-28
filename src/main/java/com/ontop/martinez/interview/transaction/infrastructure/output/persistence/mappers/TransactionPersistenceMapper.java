package com.ontop.martinez.interview.transaction.infrastructure.output.persistence.mappers;

import com.ontop.martinez.interview.account.infrastructure.output.persistence.mappers.AccountPersistenceMapper;
import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import com.ontop.martinez.interview.transaction.infrastructure.output.persistence.models.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = AccountPersistenceMapper.class)
public interface TransactionPersistenceMapper {

    @Mapping(target = "amount", source = "transaction.amount")
    @Mapping(target = "sourceAccount", source = "transaction.destination")
    @Mapping(target = "destinationAccount", source = "transaction.source")
    TransactionEntity toTransactionEntity(Transaction transaction);

    @Mapping(target = "amount", source = "transactionEntity.amount")
    @Mapping(target = "destination", source = "transactionEntity.sourceAccount")
    @Mapping(target = "source", source = "transactionEntity.destinationAccount")
    Transaction transactionEntityToTransaction(TransactionEntity transactionEntity);

}
