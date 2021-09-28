package com.assignment.ledger.handler;

import com.assignment.ledger.domain.Payment;
import com.assignment.ledger.repository.PaymentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PaymentHandlerTest {

    @InjectMocks
    PaymentHandler paymentHandler;

    @Mock
    List<Payment> paymentList;

    @Mock
    PaymentRepository paymentRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testStoreBorrowerInformationIntoDB() throws Exception{
        paymentHandler.storePaymentInformationIntoDB("ICICI", "Harry", 15000L, 2);
        Mockito.when(paymentRepository.findByBankNameEqualsAndBorrowerNameEqualsAndLastLumpSumEmiNoLessThanEqual("ICICI", "Harry", 5)).thenReturn(paymentList);
    }
}
