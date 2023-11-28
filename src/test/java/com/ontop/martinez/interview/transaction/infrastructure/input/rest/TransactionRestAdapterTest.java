package com.ontop.martinez.interview.transaction.infrastructure.input.rest;

import com.ontop.martinez.interview.transaction.application.ports.input.CreateTransactionUseCase;
import com.ontop.martinez.interview.transaction.domain.model.Transaction;
import com.ontop.martinez.interview.transaction.domain.model.TransactionStatus;
import com.ontop.martinez.interview.transaction.infrastructure.input.rest.data.TransactionRequestDTO;
import com.ontop.martinez.interview.transaction.infrastructure.output.rest.data.TransactionResponseDTO;
import com.ontop.martinez.interview.transaction.infrastructure.output.rest.mappers.TransactionResponseMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TransactionRestAdapterTest {

    @Mock
    private CreateTransactionUseCase createTransactionUseCase;

    @Mock
    private TransactionResponseMapper transactionResponseMapper;

    @InjectMocks
    private TransactionRestAdapter transactionRestAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTransaction() {
        // Arrange
        TransactionRequestDTO requestDTO = new TransactionRequestDTO();
        requestDTO.setAccountNumber("123456");
        requestDTO.setAmount(BigDecimal.valueOf(100));

        Transaction transaction = Transaction.builder()
                .status(TransactionStatus.PROCESSING)
                .amount(BigDecimal.valueOf(100))
                .build();

        when(createTransactionUseCase.createTransaction("123456", BigDecimal.valueOf(100))).thenReturn(transaction);

        TransactionResponseDTO responseDTO = new TransactionResponseDTO();
        responseDTO.setId(123L);
        responseDTO.setFee(BigDecimal.valueOf(10));
        when(transactionResponseMapper.transactionToResponseDTO(transaction)).thenReturn(responseDTO);

        TransactionResponseDTO transactionResponseDTO = transactionRestAdapter.createTransaction(requestDTO);

        assertEquals(responseDTO, transactionResponseDTO);
    }
}
