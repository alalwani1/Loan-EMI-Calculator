package com.assignment.ledger.handler;

import com.assignment.ledger.domain.Borrower;
import com.assignment.ledger.domain.Payment;
import com.assignment.ledger.repository.BorrowerRepository;
import com.assignment.ledger.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BalanceHandler {
    private Logger LOGGER = LoggerFactory.getLogger(PaymentHandler.class);

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BorrowerRepository borrowerRepository;

    private List<Payment> paymentsRecords;

    private Borrower borrower;

    private Long getAmountPayedTillLastLumpSumPaid(List<Payment> paymentsRecords, int emiMonthlyAmount, int askedEmiNo){
        Long amountPayedTillLastLumpSumPaid = 0L;
        for(Payment paymentDetails : paymentsRecords){
            if(askedEmiNo>=paymentDetails.getLastLumpSumEmiNo()) {
                amountPayedTillLastLumpSumPaid += ((paymentDetails.getTotalEmiPaid() * emiMonthlyAmount) + paymentDetails.getLumpSum());
            }
        }
        return amountPayedTillLastLumpSumPaid;
    }

    private Long getAmountPayedTillAskedEmiNo(int askedEmiNo, int lastLumpSumEmiNo, int emiMonthlyAmount){
        Long amountPayedTillAskedEmiNo = 0L;
        amountPayedTillAskedEmiNo += ((askedEmiNo - lastLumpSumEmiNo)*emiMonthlyAmount);
        return amountPayedTillAskedEmiNo;
    }

    public void getBalanceDetails(String bankName, String borrowerName, int askedEmiNo){
        Long amountPaidTillNow = 0L;
        Long remainingAmount = 0L;
        double totalEmisRemaining = 0;
        try{
            borrower = borrowerRepository.findByBankNameAndBorrowerName(bankName, borrowerName);
            paymentsRecords =  paymentRepository.findByBankNameEqualsAndBorrowerNameEqualsAndLastLumpSumEmiNoLessThanEqual(bankName, borrowerName, askedEmiNo);

            //calculation of amount paid till last lumpSum paid
            if(paymentsRecords.size()>0){
                amountPaidTillNow += getAmountPayedTillLastLumpSumPaid(paymentsRecords, borrower.getEmiMonthlyAmount(), askedEmiNo);
            }

            //calculation of amount paid till askedEmiNo
            if(borrower.getLastLumpSumEmiNo()<=askedEmiNo){
                amountPaidTillNow += getAmountPayedTillAskedEmiNo(askedEmiNo, borrower.getLastLumpSumEmiNo(), borrower.getEmiMonthlyAmount());
            }

            //asked emi details are related to past emi records
            if(amountPaidTillNow == 0L){
                amountPaidTillNow = (long)(borrower.getEmiMonthlyAmount()*askedEmiNo);
            }

            remainingAmount = borrower.getTotalAmount()-amountPaidTillNow;

            totalEmisRemaining = Math.ceil(remainingAmount*1.0/borrower.getEmiMonthlyAmount());

            LOGGER.info("{} {} {} {}", bankName, borrowerName, amountPaidTillNow, (int)totalEmisRemaining);

        }
        catch (Exception exe){
            LOGGER.error("Error occurred inside getBalanceDetails method: "+exe.getMessage());
        }
    }
}
