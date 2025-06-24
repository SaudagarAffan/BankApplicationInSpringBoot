package com.bank.controllers;

import com.bank.models.Account; 
import com.bank.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController 
{

	@Autowired
	private final AccountService accountService;

	public AccountController(AccountService accountService) 
	{
		this.accountService = accountService;
	}

	@PostMapping("/add")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) 
	{
		return ResponseEntity.ok(accountService.addAccount(account));
	}

	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable String accountNumber) 
	{
		boolean deleted = accountService.deleteAccount(accountNumber);
		return deleted ? ResponseEntity.ok("Account deleted successfully!") :
			ResponseEntity.badRequest().body("Account not found!");
	}

	@GetMapping("/{accountNumber}")
	public ResponseEntity<Optional<Account>> getAccount(@PathVariable String accountNumber) 
	{
		return ResponseEntity.ok(accountService.getAccountByNumber(accountNumber));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Account>> getAllAccounts() 
	{
		return ResponseEntity.ok(accountService.getAllAccounts());
	}
}