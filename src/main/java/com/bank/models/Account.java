package com.bank.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "all_accounts")
public class Account 
{

	@Id
	@Column(name = "account_number", nullable = false, unique = true)
	private String accountNumber;

	@Column(name = "account_holder", nullable = false)
	private String accountHolder;

	@Column(name = "balance", nullable = false)
	private BigDecimal balance;

	public Account() 
	{

	}

	public Account(String accountNumber, String accountHolder, String password, BigDecimal balance) 
	{
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
