package com.bank.controllers;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController 
{
    @GetMapping("/")
    public String homePage() 
    {
        return "index"; 
    }

    @GetMapping("/dashboard")
    public String dashboardPage() 
    {
        return "dashboard"; 
    }
}
