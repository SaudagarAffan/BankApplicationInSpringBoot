package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bank")
public class DemoApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(DemoApplication.class, args);
	}
}
