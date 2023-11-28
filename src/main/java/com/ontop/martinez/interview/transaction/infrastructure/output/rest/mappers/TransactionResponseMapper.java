package com.ontop.martinez.interview.transaction.infrastructure.output.rest.mappers;

import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import com.ontop.martinez.interview.transaction.infrastructure.output.rest.data.TransactionResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionResponseMapper {

    @Mapping(target = "sourceAccountNumber", source = "transaction.source.accountNumber")
    @Mapping(target = "destinationAccountNumber", source = "transaction.destination.accountNumber")
    TransactionResponseDTO transactionToResponseDTO (Transaction transaction);
}
