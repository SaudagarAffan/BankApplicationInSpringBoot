package com.bank.demo.exception;

public class InsufficientBalanceException extends RuntimeException 
{
    public InsufficientBalanceException(String message) 
    {
        super(message);
    }
}
