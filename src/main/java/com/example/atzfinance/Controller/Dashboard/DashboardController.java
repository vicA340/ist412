package com.example.atzfinance.Controller.Dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.atzfinance.Model.User;
import com.example.atzfinance.Service.LoanService;
import com.example.atzfinance.Service.LoggingService;
import com.example.atzfinance.Service.LoginService;

@Controller
public class DashboardController {
    
    @Autowired
    LoginService userDetailsService;
    
    @Autowired
    private LoanService loanService;
    
    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {    
        User user = userDetailsService.loadUserByUsername(authentication.getName());
        model.addAttribute("isUnderwriter", user.getIsUnderwriter());
        model.addAttribute("listLoans", loanService.getAllLoans());
        return "Dashboard/dashboard";
    }

    @GetMapping("/audit")
    public String auditLogs(Model model, Authentication authentication) {    
        User user = userDetailsService.loadUserByUsername(authentication.getName());
        if (!user.getIsUnderwriter()) return "Dashboard/dashboard";
        new LoggingService().log("User [" + user.getId() + "] accessed logs.");
        return "log";
    }
}
