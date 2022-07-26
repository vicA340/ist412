package com.example.atzfinance.Controller;

import com.example.atzfinance.Service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class MainController {
     
    @Autowired
    private LoanService loanService;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}