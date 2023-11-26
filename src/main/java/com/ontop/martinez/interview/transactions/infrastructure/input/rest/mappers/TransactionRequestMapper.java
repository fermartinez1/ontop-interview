package com.ontop.martinez.interview.transactions.infrastructure.input.rest.mappers;

import com.ontop.martinez.interview.transactions.domain.model.Transaction;
import com.ontop.martinez.interview.transactions.infrastructure.input.rest.entities.TransactionRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionRequestMapper {

    TransactionRequestDTO transactionToTransactionRequestDto(Transaction transaction);
    Transaction transactionRequestDtoToTransaction(TransactionRequestDTO transactionRequestDTO);
}
