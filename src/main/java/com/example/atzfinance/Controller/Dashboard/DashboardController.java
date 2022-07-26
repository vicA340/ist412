package com.example.atzfinance.Controller.Dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.atzfinance.Service.LoanService;

@Controller
public class DashboardController {
    
    @Autowired
    private LoanService loanService;
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("listLoans", loanService.getAllLoans());
        return "Dashboard/dashboard";
    }
}
