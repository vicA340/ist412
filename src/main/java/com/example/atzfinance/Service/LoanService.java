package com.example.atzfinance.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atzfinance.Repository.LoanRepository;
import com.example.atzfinance.Model.Loan;
import com.example.atzfinance.Model.Loan.LoanStatus;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        return this.loanRepository.findAll();
    }

    public void saveLoan(Loan loan) {
        this.loanRepository.save(loan);
    }

    public Loan getLoanById(long id) throws RuntimeException {
        Optional<Loan> optional = loanRepository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Loan not found for id :: " + id);
        }
        return optional.get();
    }

    public void deleteLoanById(long id) {
        this.loanRepository.deleteById(id);
    }
    
    public void denyLoan(long id) {
        Loan loan = getLoanById(id);
        loan.setStatus(LoanStatus.DENIED);
        saveLoan(loan);
    }

    public void approveLoan(long id) {
        Loan loan = getLoanById(id);
        loan.setStatus(LoanStatus.APPROVED);
        saveLoan(loan);
    }
}
