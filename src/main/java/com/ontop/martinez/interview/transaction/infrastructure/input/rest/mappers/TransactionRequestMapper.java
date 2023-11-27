package com.ontop.martinez.interview.transaction.infrastructure.input.rest.mappers;

import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import com.ontop.martinez.interview.transaction.infrastructure.input.rest.data.TransactionRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionRequestMapper {

    TransactionRequestDTO transactionToTransactionRequestDto(Transaction transaction);

    Transaction transactionRequestDtoToTransaction(TransactionRequestDTO transactionRequestDTO);
}
