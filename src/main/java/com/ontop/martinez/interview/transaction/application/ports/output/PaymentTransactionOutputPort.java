package com.ontop.martinez.interview.transaction.application.ports.output;

import com.ontop.martinez.interview.transaction.domain.model.Transaction;

import java.net.URISyntaxException;

public interface PaymentTransactionOutputPort {

    void createPaymentTransaction(Transaction transaction) throws URISyntaxException;
}
