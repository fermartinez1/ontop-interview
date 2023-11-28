package com.ontop.martinez.interview.payment.infrastructure.rest.mappers;

import com.ontop.martinez.interview.payment.domain.model.Payment;
import com.ontop.martinez.interview.payment.infrastructure.rest.data.request.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "source.account", source = "payment.source")
    @Mapping(target = "destination.account", source = "payment.destination")
    PaymentDTO paymentToPaymentDto(Payment payment);
}
