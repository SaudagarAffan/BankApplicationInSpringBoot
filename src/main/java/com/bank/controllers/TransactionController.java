package com.bank.controllers;

import com.bank.models.Transaction;
import com.bank.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController 
{

	private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) 
	{
		this.transactionService = transactionService;
	}

	@PostMapping("/{accountNumber}/{type}/{amount}")
	public String performTransaction
	(@PathVariable String accountNumber, @PathVariable String type, @PathVariable BigDecimal amount) 
	{
		return transactionService.performTransaction(accountNumber, type, amount);
	}

	@GetMapping("/history/{accountNumber}")
	public List<Transaction> getTransactionHistory(@PathVariable String accountNumber) 
	{
		return transactionService.getTransactionHistory(accountNumber);
	}
}
