package com.assignment.ledger.handler;

import com.assignment.ledger.domain.Borrower;
import com.assignment.ledger.repository.BorrowerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BorrowerHandler {

    @Autowired
    private BorrowerRepository borrowerRepository;

    private Logger LOGGER = LoggerFactory.getLogger(BorrowerRepository.class);

    private Long calculateInterest(Long principal, int noOfYears, double rateOfInterest) {
        double interestValue;
        interestValue = Math.ceil((principal*noOfYears*rateOfInterest)/100.0);
        return (long)interestValue;
    }

    private long calculateTotalAmount(long principal, long interest){
        return principal+interest;
    }

    private int calculateInitialNumberOfEMIs(int noOfYears){
        return noOfYears*12;
    }

    private int calculateMonthlyEMIAmount(long totalAmount, int totalNumberOfEmisInBeginning){
        double monthlyEmiAmount;
        monthlyEmiAmount = Math.ceil(totalAmount/(totalNumberOfEmisInBeginning*1.0));
        return  (int)monthlyEmiAmount;
    }

    public void storeBorrowerInformationIntoDB(String bankName, String borrowerName, Long principal, int noOfYears, double rateOfInterest, int lastLumpSumEmiNo){
        long interest, totalAmount;
        int totalNumberOfEmisInBeginning, emiMonthlyAmount;
        try{
            interest =  calculateInterest(principal, noOfYears, rateOfInterest);
            totalAmount = calculateTotalAmount(principal, interest);
            totalNumberOfEmisInBeginning = calculateInitialNumberOfEMIs(noOfYears);
            emiMonthlyAmount = calculateMonthlyEMIAmount(totalAmount, totalNumberOfEmisInBeginning);
            borrowerRepository.save(new Borrower(bankName, borrowerName, principal, noOfYears,
                    rateOfInterest, totalAmount, emiMonthlyAmount, lastLumpSumEmiNo));
        }
        catch (Exception exe){
            LOGGER.error("Error occurred inside storeBorrowerInformationIntoDB method: "+exe.getMessage());
        }
    }
}
