package com.bank.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "all_transactions")
public class Transaction 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionid;

	@Column(nullable = false)
	private String accountNumber;  // Changed from Account object to String

	private String transactionType; // DEPOSIT or WITHDRAW

	private BigDecimal amount;

	private LocalDateTime dateTime;

	public Transaction() {}

	//  Updated constructor to use accountNumber instead of Account object
	public Transaction(String accountNumber, String transactionType, BigDecimal amount, LocalDateTime dateTime) 
	{
		this.accountNumber = accountNumber;
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateTime = dateTime;
	}

	// Getters and Setters
	public Long getTransactionid() { return transactionid; }
	public void setTransactionid(Long transactionid) { this.transactionid = transactionid; }

	public String getAccountNumber() { return accountNumber; }
	public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

	public String getTransactionType() { return transactionType; }
	public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

	public BigDecimal getAmount() { return amount; }
	public void setAmount(BigDecimal amount) { this.amount = amount; }

	public LocalDateTime getDateTime() { return dateTime; }
	public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}
