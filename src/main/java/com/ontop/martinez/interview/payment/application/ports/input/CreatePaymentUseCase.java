package com.ontop.martinez.interview.payment.application.ports.input;

import com.ontop.martinez.interview.payment.domain.model.Payment;
import com.ontop.martinez.interview.transaction.domain.model.Transaction;

import java.util.Optional;

public interface CreatePaymentUseCase {

    Optional<Payment> createPaymentInProvider(Transaction transaction);

}
