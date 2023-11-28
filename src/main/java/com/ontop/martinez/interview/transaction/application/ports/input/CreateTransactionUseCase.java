package com.ontop.martinez.interview.transaction.application.ports.input;

import com.ontop.martinez.interview.transaction.domain.model.Transaction;

import java.math.BigDecimal;

public interface CreateTransactionUseCase {

     Transaction createTransaction(String sourceAccountNumber, BigDecimal amount);

}
