package com.ontop.martinez.interview.transaction.application.ports.output;

import com.ontop.martinez.interview.transaction.domain.model.Transaction;
public interface TransactionOutputPort {

    void saveTransaction(Transaction transaction);

}
