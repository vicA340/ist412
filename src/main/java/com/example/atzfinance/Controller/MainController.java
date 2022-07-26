package com.example.atzfinance.Controller;

import com.example.atzfinance.Service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class MainController {
     
    @Autowired
    private LoanService loanService;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("listLoans", loanService.getAllLoans());
        
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}