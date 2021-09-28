package com.assignment.ledger.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandHandler {

    @Autowired
    private PaymentHandler paymentHandler;

    @Autowired
    private BorrowerHandler borrowerHandler;

    @Autowired
    private BalanceHandler balanceHandler;

    private String values[];

    private Logger LOGGER = LoggerFactory.getLogger(CommandHandler.class);

    public void getCommand(String command) {
        values = command.split(" ");
        try {
            switch (values[0]) {
                case "LOAN":
                    //passing parameters details: bankName, borrowerName, principal, noOfYears, rateOfInterest, lastLumpSumEmiNo;
                    borrowerHandler.storeBorrowerInformationIntoDB(values[1], values[2], Long.parseLong(values[3]), Integer.parseInt(values[4]),
                            Double.parseDouble(values[5]), 0);
                    break;
                case "PAYMENT":
                    //passing parameters details: bankName, borrowerName, lumpSum, askedEmiNo
                    paymentHandler.storePaymentInformationIntoDB(values[1], values[2], Long.parseLong(values[3]), Integer.parseInt(values[4]));
                    break;
                case "BALANCE":
                    //passing parameters details: bankName, borrowerName, askedEmiNo
                    balanceHandler.getBalanceDetails(values[1], values[2], Integer.parseInt(values[3]));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + values[0]);
            }
        }
        catch (Exception exe){
            LOGGER.error("Error occurred inside getCommand method: "+exe.getMessage());
        }
    }
}