package com.ontop.martinez.interview.transaction.infrastructure.output.rest;

import com.ontop.martinez.interview.transaction.application.ports.output.PaymentTransactionOutputPort;
import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@Component
public class PaymentProviderAdapter implements PaymentTransactionOutputPort {

    @Override
    public void createPaymentTransaction(Transaction transaction) throws URISyntaxException {
    }
}
