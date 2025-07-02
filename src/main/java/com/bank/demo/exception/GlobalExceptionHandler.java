package com.bank.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException ex) 
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<String> handleInsufficientBalanceException(InsufficientBalanceException ex) 
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AccountAlreadyExistsException.class)
	public ResponseEntity<String> handleAccountExists(AccountAlreadyExistsException ex) {
	    return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
	}
}
