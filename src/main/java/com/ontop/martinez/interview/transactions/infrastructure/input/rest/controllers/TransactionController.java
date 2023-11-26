package com.ontop.martinez.interview.transactions.infrastructure.input.rest.controllers;

import com.ontop.martinez.interview.transactions.application.ports.input.CreateTransactionUseCase;
import com.ontop.martinez.interview.transactions.domain.model.Transaction;
import com.ontop.martinez.interview.transactions.infrastructure.input.rest.entities.TransactionRequestDTO;
import com.ontop.martinez.interview.transactions.infrastructure.input.rest.mappers.TransactionRequestMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController{

    private final CreateTransactionUseCase createTransactionUseCase;

    private final TransactionRequestMapper transactionRequestMapper;
    @PostMapping
    public Transaction createTransaction (@RequestBody TransactionRequestDTO transactionRequestDTO){
        return createTransactionUseCase.createTransaction(transactionRequestMapper.transactionRequestDtoToTransaction(transactionRequestDTO));
    }
}
