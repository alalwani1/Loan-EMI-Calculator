package com.assignment.ledger.repository;

import com.assignment.ledger.domain.Payment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PaymentRepositoryTest {

    @Mock
    List<Payment> paymentList;

    @Mock
    PaymentRepository paymentRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByBankNameEqualsAndBorrowerNameEqualsAndLastLumpSumEmiNoLessThanEqual() throws Exception{
        Mockito.when(paymentRepository.findByBankNameEqualsAndBorrowerNameEqualsAndLastLumpSumEmiNoLessThanEqual("MBI", "Harry", 5)).thenReturn(paymentList);
        /*
        paymentHandler.storePaymentInformationIntoDB("MBI", "Harry", 7000L, 12);
        List<Payment> paymentList= paymentRepository.findByBankNameEqualsAndBorrowerNameEqualsAndLastLumpSumEmiNoLessThanEqual("MBI", "Harry", 12);
        assertEquals("MBI", paymentList.get(0).getBankName());
        assertEquals("Harry", paymentList.get(0).getBorrowerName());
        assertEquals(70000L, paymentList.get(0).getLumpSum());
        assertEquals(12, paymentList.get(0).getLastLumpSumEmiNo());*/
    }
}
