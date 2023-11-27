package com.ontop.martinez.interview.transaction.domain.exception;


public class NotEnoughFundsException extends RuntimeException {

    public NotEnoughFundsException(String message){
        super(message);
    }
}
