package com.assignment.ledger.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String bankName;

    private String borrowerName;

    private long lumpSum;

    private int totalEmiPaid;

    private int lastLumpSumEmiNo;

    public Payment() {
    }

    public Payment(String bankName, String borrowerName, long lumpSum, int totalEmiPaid,  int lastLumpSumEmiNo) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.lumpSum = lumpSum;
        this.totalEmiPaid = totalEmiPaid;
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

    public long getLumpSum() {
        return lumpSum;
    }

    public void setLumpSum(long lumpSum) {
        this.lumpSum = lumpSum;
    }

    public int getTotalEmiPaid() {
        return totalEmiPaid;
    }

    public void setTotalEmiPaid(int totalEmiPaid) {
        this.totalEmiPaid = totalEmiPaid;
    }

    public int getLastLumpSumEmiNo() {
        return lastLumpSumEmiNo;
    }

    public void setLastLumpSumEmiNo(int lastLumpSumEmiNo) {
        this.lastLumpSumEmiNo = lastLumpSumEmiNo;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", lumpSum=" + lumpSum +
                ", totalEmiPaid=" + totalEmiPaid +
                ", lastLumpSumEmiNo=" + lastLumpSumEmiNo +
                '}';
    }
}