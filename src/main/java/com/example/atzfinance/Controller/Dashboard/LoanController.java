package com.example.atzfinance.Controller.Dashboard;

import com.example.atzfinance.Model.Loan;
import com.example.atzfinance.Model.User;
import com.example.atzfinance.Service.LoanService;
import com.example.atzfinance.Service.LoggingService;
import com.example.atzfinance.Service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.security.core.Authentication;

@Controller
public class LoanController {

    @Autowired
    LoginService userDetailsService;

    @Autowired
    private LoanService loanService;

    @GetMapping("/loan")
    public String GetLoan(Model model) {
        model.addAttribute("loan", new Loan());
        return "Dashboard/LoanApplication/loan_application";
    }

    @PostMapping("/loan")
    public String PostLoan(@ModelAttribute Loan loan, Authentication authentication) {
        loan.setStatus(Loan.LoanStatus.PENDING);
        loanService.saveLoan(loan);
        log(authentication.getName(), "applied for", loan.getId());
        return "redirect:/dashboard";
    }

    @GetMapping("/deleteLoan/{id}")
    public String deleteLoan(@PathVariable( value = "id" ) long id, Authentication authentication) {
        this.loanService.deleteLoanById(id);
        log(authentication.getName(), "deleted", id);
        return "redirect:/dashboard";
    }

    @GetMapping("/denyLoan/{id}")
    public String denyLoan(@PathVariable( value = "id" ) long id, Authentication authentication) {
        this.loanService.denyLoan(id);
        log(authentication.getName(), "denied", id);
        return "redirect:/dashboard";
    }

    @GetMapping("/approveLoan/{id}")
    public String approveLoan(@PathVariable( value = "id" ) long id, Authentication authentication) {
        this.loanService.approveLoan(id);
        log(authentication.getName(), "approved", id);
        return "redirect:/dashboard";
    }

    private void log(String username, String action, Long loanId) {
        User user = userDetailsService.loadUserByUsername(username);
        new LoggingService().log("User [" + user.getId() + "] " + action + " loan ID: [" + loanId + "]");
    }
}
