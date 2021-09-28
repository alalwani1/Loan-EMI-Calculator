package com.assignment.ledger.handler;

import com.assignment.ledger.domain.Borrower;
import com.assignment.ledger.domain.Payment;
import com.assignment.ledger.repository.BorrowerRepository;
import com.assignment.ledger.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentHandler {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BorrowerRepository borrowerRepository;

    private Borrower borrower;

    private Logger LOGGER = LoggerFactory.getLogger(PaymentHandler.class);

    public void storePaymentInformationIntoDB(String bankName, String borrowerName, Long lumpSum, int askedEmiNo){
        try{
            borrower = borrowerRepository.findByBankNameAndBorrowerName(bankName, borrowerName);
            int totalEmisPaid = askedEmiNo - borrower.getLastLumpSumEmiNo();
            borrower.setLastLumpSumEmiNo(askedEmiNo);
            borrowerRepository.save(borrower);
            borrower = borrowerRepository.findByBankNameAndBorrowerName(bankName, borrowerName);
            paymentRepository.save(new Payment(bankName, borrowerName, lumpSum, totalEmisPaid, askedEmiNo));
        }
        catch (Exception exe){
            LOGGER.error("Error occurred inside storePaymentInformationIntoDB method: "+exe.getMessage());
        }
    }
}