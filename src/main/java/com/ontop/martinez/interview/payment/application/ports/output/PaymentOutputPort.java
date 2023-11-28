package com.ontop.martinez.interview.payment.application.ports.output;

import com.ontop.martinez.interview.payment.domain.model.Payment;

import java.util.Optional;

public interface PaymentOutputPort {

    Optional<Payment> createPaymentInProvider(Payment payment);
}
