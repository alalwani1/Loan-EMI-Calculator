package com.assignment.ledger.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Borrower {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String bankName;

    private String borrowerName;

    private Long principal;

    private int noOfYears;

    private double rateOfInterest;

    private Long totalAmount;

    private int emiMonthlyAmount;

    private int lastLumpSumEmiNo;

    public Borrower() {
    }

    public Borrower(String bankName, String borrowerName, Long principal, int noOfYears, double rateOfInterest, Long totalAmount, int emiMonthlyAmount, int lastLumpSumEmiNo) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.noOfYears = noOfYears;
        this.rateOfInterest = rateOfInterest;
        this.totalAmount = totalAmount;
        this.emiMonthlyAmount = emiMonthlyAmount;
        this.lastLumpSumEmiNo = lastLumpSumEmiNo;
    }

    public long getId() {
        return id;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Long getPrincipal() {
        return principal;
    }

    public void setPrincipal(Long principal) {
        this.principal = principal;
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getEmiMonthlyAmount() {
        return emiMonthlyAmount;
    }

    public void setEmiMonthlyAmount(int emiMonthlyAmount) {
        this.emiMonthlyAmount = emiMonthlyAmount;
    }

    public int getLastLumpSumEmiNo() {
        return lastLumpSumEmiNo;
    }

    public void setLastLumpSumEmiNo(int lastLumpSumEmiNo) {
        this.lastLumpSumEmiNo = lastLumpSumEmiNo;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", principal=" + principal +
                ", noOfYears=" + noOfYears +
                ", rateOfInterest=" + rateOfInterest +
                ", totalAmount=" + totalAmount +
                ", emiMonthlyAmount=" + emiMonthlyAmount +
                ", lastLumpSumEmiNo=" + lastLumpSumEmiNo +
                '}';
    }
}
