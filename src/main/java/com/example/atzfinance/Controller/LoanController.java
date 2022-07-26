package com.example.atzfinance.Controller;

import com.example.atzfinance.Model.Loan;
import com.example.atzfinance.Model.LoanStatus;
import com.example.atzfinance.Service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/loan")
    public String GetLoan(Model model) {
        model.addAttribute("loan", new Loan());
        return "loan_application";
    }

    @PostMapping("/loan")
    public String PostLoan(@ModelAttribute Loan loan) {
        loan.setStatus(LoanStatus.PENDING);
        loanService.saveLoan(loan);
        return "redirect:/dashboard";
    }

    @GetMapping("/deleteLoan/{id}")
    public String deleteLoan(@PathVariable( value = "id" ) long id) {
        this.loanService.deleteLoanById(id);
        return "redirect:/dashboard";
    }

    @GetMapping("/denyLoan/{id}")
    public String denyLoan(@PathVariable( value = "id" ) long id) {
        this.loanService.denyLoan(id);
        return "redirect:/dashboard";
    }

    @GetMapping("/approveLoan/{id}")
    public String approveLoan(@PathVariable( value = "id" ) long id) {
        this.loanService.approveLoan(id);
        return "redirect:/dashboard";
    }
}
