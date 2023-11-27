package com.ontop.martinez.interview.transaction.infrastructure.input.rest;

import com.ontop.martinez.interview.transaction.application.ports.input.CreateTransactionUseCase;
import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import com.ontop.martinez.interview.transaction.infrastructure.input.rest.data.TransactionRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionRestAdapter {

    private final CreateTransactionUseCase createTransactionUseCase;

    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        return createTransactionUseCase.createTransaction(transactionRequestDTO.getAccountNumber(), transactionRequestDTO.getAmount());

    }
}
