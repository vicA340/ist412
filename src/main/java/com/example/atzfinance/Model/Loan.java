package com.example.atzfinance.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="loans")
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="loanAmount", scale=2)
    private double loanAmount;

    @Column(name="creditScore")
    private int creditScore;

    @Column(name="status")
    private LoanStatus status;

    @Column(name="belongsTo")
    private Long belongsTo;

    public enum LoanStatus {
        PENDING, DENIED, APPROVED
    }
    
    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBelongsTo(long id) {
        this.belongsTo = id;
    }

    public long getBelongsTo() {
        return belongsTo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
    
}
