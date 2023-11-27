package com.ontop.martinez.interview.transaction.infrastructure.output.rest.mappers;

import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.request.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "destinationDTO", source = "transaction.destination")
    @Mapping(target = "sourceDTO", source = "transaction.source")
    PaymentDTO transactionToPaymentDto(Transaction transaction);
}
