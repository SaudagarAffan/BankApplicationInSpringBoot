package com.bank.demo.exception;

public class AccountNotFoundException extends RuntimeException 
{
	public AccountNotFoundException(String message) 
	{
		super(message);
	}
}
