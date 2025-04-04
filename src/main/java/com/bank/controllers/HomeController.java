package com.bank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//HomeController.java
@RestController
@RequestMapping("/home")  // Change the mapping to avoid conflict
public class HomeController 
{
	@GetMapping("/")
	public String home() 
	{
		return "Welcome to Home Page!";
	}
}


