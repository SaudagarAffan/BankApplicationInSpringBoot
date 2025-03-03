package com.bank.services;

import com.bank.models.Account;
import com.bank.models.Transaction;
import com.bank.repositories.TransactionRepository;
import com.bank.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService 
{
	private final TransactionRepository transactionRepository;
	private final AccountRepository accountRepository;

	public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) 
	{
		this.transactionRepository = transactionRepository;
		this.accountRepository = accountRepository;
	}

	public String performTransaction(String accountNumber, String type, BigDecimal amount) 
	{
		Optional<Account> accountOpt = accountRepository.findByAccountNumber(accountNumber);
		if (accountOpt.isEmpty()) 
		{
			return "Account not found!";
		}

		Account account = accountOpt.get();
		if (type.equalsIgnoreCase("DEPOSIT")) 
		{
			account.setBalance(account.getBalance().add(amount));
		} 
		else if (type.equalsIgnoreCase("WITHDRAW")) 
		{
			if (account.getBalance().compareTo(amount) < 0) 
			{
				return "Insufficient funds!";
			}
			account.setBalance(account.getBalance().subtract(amount));
		} 
		else
		{
			return "Invalid transaction type!";
		}

		accountRepository.save(account);
		Transaction transaction = new Transaction(accountNumber, type, amount, LocalDateTime.now());
		transactionRepository.save(transaction);

		return "Transaction successful!";
	}

	public List<Transaction> getTransactionHistory(String accountNumber) 
	{
		return transactionRepository.findByAccountNumber(accountNumber);
	}
}
