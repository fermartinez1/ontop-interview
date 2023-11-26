package com.ontop.martinez.interview.transactions.application.ports.output;

import com.ontop.martinez.interview.transactions.domain.model.Transaction;

import java.net.URISyntaxException;

public interface PaymentTransactionOutputPort {

    void createPaymentTransaction(Transaction transaction) throws URISyntaxException;
}
