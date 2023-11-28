package com.ontop.martinez.interview.transaction.domain.service;

import com.ontop.martinez.interview.account.application.ports.input.GetAccountByNumberUseCase;
import com.ontop.martinez.interview.account.application.ports.input.GetDefaultAccountUseCase;
import com.ontop.martinez.interview.account.domain.model.Account;
import com.ontop.martinez.interview.payment.application.ports.input.CreatePaymentUseCase;
import com.ontop.martinez.interview.payment.domain.exception.ProviderPaymentException;
import com.ontop.martinez.interview.payment.domain.model.Payment;
import com.ontop.martinez.interview.person.domain.model.Person;
import com.ontop.martinez.interview.transaction.application.ports.output.TransactionOutputPort;
import com.ontop.martinez.interview.wallet.application.ports.input.CreateWalletTopUpTransactionUseCase;
import com.ontop.martinez.interview.wallet.application.ports.input.CreateWalletWithdrawTransactionUseCase;
import com.ontop.martinez.interview.wallet.application.ports.input.GetWalletBalanceUseCase;
import com.ontop.martinez.interview.transaction.domain.exception.AccountNotFoundException;
import com.ontop.martinez.interview.transaction.domain.exception.InsufficientFundsException;
import com.ontop.martinez.interview.transaction.domain.model.*;
import com.ontop.martinez.interview.wallet.domain.exception.WalletTransactionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    @Mock
    private TransactionOutputPort transactionOutputPort;

    @Mock
    private GetAccountByNumberUseCase getAccountByNumberUseCase;

    @Mock
    private CreatePaymentUseCase createPaymentUseCase;

    @Mock
    private GetDefaultAccountUseCase getDefaultAccountUseCase;

    @Mock
    private GetWalletBalanceUseCase getWalletBalanceUseCase;

    @Mock
    private CreateWalletTopUpTransactionUseCase createWalletTopUpTransactionUseCase;

    @Mock
    private CreateWalletWithdrawTransactionUseCase createWalletWithdrawTransactionUseCase;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTransaction_Success() {
        String accountNumber = "123456";
        BigDecimal amount = BigDecimal.valueOf(100);

        BigDecimal expectedTotalAmount = BigDecimal.valueOf(100).multiply( BigDecimal.valueOf(1.10));

        Account destinationAccount = new Account();
        Person person = new Person();
        person.setId(1L);
        destinationAccount.setUser(person);
        when(getAccountByNumberUseCase.getAccountByNumber(accountNumber)).thenReturn(Optional.of(destinationAccount));

        Payment payment = Payment.builder()
                .status("PROCESSING").build();

        when(createPaymentUseCase.createPaymentInProvider(any())).thenReturn(Optional.of(payment));
        when(getDefaultAccountUseCase.getDefaultSourceAccount()).thenReturn(new Account());
        when(getWalletBalanceUseCase.getWalletBalance(1L)).thenReturn(BigDecimal.valueOf(150));

        Transaction transaction = transactionService.createTransaction(accountNumber, amount);

        assertNotNull(transaction);
        assertEquals(TransactionStatus.PROCESSING, transaction.getStatus());
        verify(createWalletTopUpTransactionUseCase, times(1)).createWalletTopUpTransaction(person.getId(), expectedTotalAmount);
        verify(transactionOutputPort, times(2)).saveTransaction(any());
        verify(transactionOutputPort, times(2)).saveTransaction(any());
        assertEquals(transaction.getTotalAmount(), expectedTotalAmount);
    }

    @Test
    void testCreateTransaction_AccountNotFound() {
        String accountNumber = "123456";
        BigDecimal amount = BigDecimal.valueOf(100);

        when(getAccountByNumberUseCase.getAccountByNumber(accountNumber)).thenReturn(Optional.empty());


        assertThrows(AccountNotFoundException.class, () -> transactionService.createTransaction(accountNumber, amount));
        verify(transactionOutputPort, never()).saveTransaction(any());
    }

    @Test
    void testCreateTransaction_InsufficientFunds() {
        String accountNumber = "123456";
        BigDecimal amount = BigDecimal.valueOf(200);
        Account destinationAccount = new Account();
        Person person = new Person();
        person.setId(1L);
        destinationAccount.setUser(person);
        when(getAccountByNumberUseCase.getAccountByNumber(accountNumber)).thenReturn(Optional.of(destinationAccount));
        when(getWalletBalanceUseCase.getWalletBalance(1L)).thenReturn(BigDecimal.valueOf(150));

        assertThrows(InsufficientFundsException.class, () -> transactionService.createTransaction(accountNumber, amount));
        verify(transactionOutputPort, never()).saveTransaction(any());
    }

    @Test
    void testCreateTransaction_WalletTransactionException() {
        String accountNumber = "123456";
        BigDecimal amount = BigDecimal.valueOf(100);
        Account destinationAccount = new Account();
        Person person = new Person();
        person.setId(1L);
        destinationAccount.setUser(person);

        when(getAccountByNumberUseCase.getAccountByNumber(accountNumber)).thenReturn(Optional.of(destinationAccount));
        when(createWalletTopUpTransactionUseCase.createWalletTopUpTransaction(1L, BigDecimal.valueOf(110.0))).thenThrow(new WalletTransactionException("Wallet error"));
        when(getWalletBalanceUseCase.getWalletBalance(1L)).thenReturn(BigDecimal.valueOf(150));


        Transaction transaction = transactionService.createTransaction(accountNumber, amount);

        assertNotNull(transaction);
        assertEquals(TransactionStatus.FAILED_BY_WALLET, transaction.getStatus());
        verify(transactionOutputPort, times(2)).saveTransaction(any());
    }

    @Test
    void testCreateTransaction_ProviderPaymentException() {

        String accountNumber = "123456";
        BigDecimal amount = BigDecimal.valueOf(100);
        Account destinationAccount = new Account();
        Person person = new Person();
        person.setId(1L);
        destinationAccount.setUser(person);

        when(getAccountByNumberUseCase.getAccountByNumber(accountNumber)).thenReturn(Optional.of(destinationAccount));
        when(createPaymentUseCase.createPaymentInProvider(any())).thenThrow(new ProviderPaymentException("Provider error"));
        when(getWalletBalanceUseCase.getWalletBalance(1L)).thenReturn(BigDecimal.valueOf(150));

        Transaction transaction = transactionService.createTransaction(accountNumber, amount);

        assertNotNull(transaction);
        assertEquals(TransactionStatus.FAILED_BY_PROVIDER, transaction.getStatus());
        verify(transactionOutputPort, times(2)).saveTransaction(any());
        verify(createWalletWithdrawTransactionUseCase, times(1)).createWalletWithdrawTransaction(1L, BigDecimal.valueOf(110.0));
    }
}