package com.ontop.martinez.interview.transaction.infrastructure.input.rest;

import com.ontop.martinez.interview.transaction.application.ports.input.CreateTransactionUseCase;
import com.ontop.martinez.interview.transaction.infrastructure.input.rest.data.TransactionRequestDTO;
import com.ontop.martinez.interview.transaction.infrastructure.output.rest.data.TransactionResponseDTO;
import com.ontop.martinez.interview.transaction.infrastructure.output.rest.mappers.TransactionResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionRestAdapter {

    private final CreateTransactionUseCase createTransactionUseCase;

    private final TransactionResponseMapper transactionResponseMapper;

    @PostMapping
    public TransactionResponseDTO createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        return transactionResponseMapper.transactionToResponseDTO(createTransactionUseCase.createTransaction(transactionRequestDTO.getAccountNumber(), transactionRequestDTO.getAmount()));
    }
}
