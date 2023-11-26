package com.ontop.martinez.interview.transactions.application.ports.input;

import com.ontop.martinez.interview.transactions.domain.model.Transaction;

public interface CreateTransactionUseCase {

     Transaction createTransaction(Transaction transaction);

}
