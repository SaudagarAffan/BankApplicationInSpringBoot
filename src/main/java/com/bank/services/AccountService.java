package com.bank.services;

import com.bank.models.Account; 
import com.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService 
{

	@Autowired
	private AccountRepository accountRepository;

	public Account addAccount(Account account) 
	{
		return accountRepository.save(account);
	}
//-------------------------------------------------------------------------------------------------------------------------
	public Optional<Account> getAccountByNumber(String accountNumber) 
	{
		return accountRepository.findByAccountNumber(accountNumber);
	}
//-------------------------------------------------------------------------------------------------------------------------
	public boolean deleteAccount(String accountNumber) 
	{
		Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
		if (account.isPresent()) 
		{
			accountRepository.delete(account.get());
			return true;
		}
		return false;
	}
//-------------------------------------------------------------------------------------------------------------------------
	public boolean updateBalance(String accountNumber, BigDecimal amount) 
	{
		Optional<Account> accountOpt = accountRepository.findByAccountNumber(accountNumber);
		if (accountOpt.isPresent()) 
		{
			Account account = accountOpt.get();
			account.setBalance(account.getBalance().add(amount));
			accountRepository.save(account);
			return true;
		}
		return false;
	}
//-------------------------------------------------------------------------------------------------------------------------
	public List<Account> getAllAccounts() 
	{
		return accountRepository.findAll();
	}
}
