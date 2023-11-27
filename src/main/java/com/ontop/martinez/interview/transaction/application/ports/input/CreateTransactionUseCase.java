package com.ontop.martinez.interview.transaction.application.ports.input;

import com.ontop.martinez.interview.transaction.domain.model.Transaction;

public interface CreateTransactionUseCase {

     Transaction createTransaction(Long sourceAccountNumber, Double amount);

}
