package com.bank.demo.exception;

public class AccountAlreadyExistsException extends RuntimeException
{
	public AccountAlreadyExistsException(String message)
	{
		super(message);
	}

}
