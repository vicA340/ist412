package com.example.atzfinance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.example.atzfinance.Model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Override
    Optional<Loan> findById(Long id);
}
