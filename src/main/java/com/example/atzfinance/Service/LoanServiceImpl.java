package com.example.atzfinance.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atzfinance.Repository.LoanRepository;
import com.example.atzfinance.Model.Loan;
import com.example.atzfinance.Model.Loan.LoanStatus;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public List<Loan> getAllLoans() {
        return this.loanRepository.findAll();
    }

    @Override
    public void saveLoan(Loan loan) {
        this.loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(long id) {
        Optional<Loan> optional = loanRepository.findById(id);
        Loan loan = null;
        if (optional.isPresent()) {
            loan = optional.get();
        }
        else {
            throw new RuntimeException("Loan not found for id :: " + id);
        }
        return loan;
    }

    @Override
    public void deleteLoanById(long id) {
        this.loanRepository.deleteById(id);
    }

    @Override
    public void denyLoan(long id) {
        Loan loan = getLoanById(id);
        loan.setStatus(LoanStatus.DENIED);
        saveLoan(loan);
    }

    @Override
    public void approveLoan(long id) {
        Loan loan = getLoanById(id);
        loan.setStatus(LoanStatus.APPROVED);
        saveLoan(loan);
    }
}
