package com.ontop.martinez.interview.payment.domain.service;

import com.ontop.martinez.interview.payment.application.ports.input.CreatePaymentUseCase;
import com.ontop.martinez.interview.payment.application.ports.output.PaymentOutputPort;
import com.ontop.martinez.interview.payment.domain.model.Payment;
import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PaymentService implements CreatePaymentUseCase {

    private final PaymentOutputPort paymentOutputPort;

    @Override
    public Optional<Payment> createPaymentInProvider(Transaction transaction) {
        Payment payment = Payment.builder()
                .source(transaction.getSource())
                .destination(transaction.getDestination())
                .amount(transaction.getAmount()).build();

        return paymentOutputPort.createPaymentInProvider(payment);
    }
}
