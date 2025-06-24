package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bank")
public class BankMainApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(BankMainApplication.class, args);
	}	
}
