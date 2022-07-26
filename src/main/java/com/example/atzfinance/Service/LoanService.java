package com.example.atzfinance.Service;

import com.example.atzfinance.Model.Loan;

import java.util.List;

public interface LoanService {
    List<Loan> getAllLoans();
    void saveLoan(Loan loan);
    Loan getLoanById(long id);
    void deleteLoanById(long id);
    void denyLoan(long id);
    void approveLoan(long id);
}
