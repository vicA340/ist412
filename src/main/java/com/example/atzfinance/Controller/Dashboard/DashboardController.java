package com.example.atzfinance.Controller.Dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.atzfinance.Model.User;
import com.example.atzfinance.Service.LoanService;

@Controller
public class DashboardController {
    
    @Autowired
    private LoanService loanService;
    
    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        model.addAttribute("listLoans", loanService.getAllLoans());
    
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("isUnderwriter", user);
        return "Dashboard/dashboard";
    }
}
