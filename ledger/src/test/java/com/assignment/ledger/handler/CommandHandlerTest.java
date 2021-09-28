//package com.assignment.ledger.handler;
//
//import com.assignment.ledger.domain.Borrower;
//import com.assignment.ledger.domain.Payment;
//import com.assignment.ledger.repository.BorrowerRepository;
//import com.assignment.ledger.repository.PaymentRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.List;
//
//@RunWith(MockitoJUnitRunner.Silent.class)
//public class CommandHandlerTest {
//
//    @InjectMocks
//    CommandHandler commandHandler;
//
//    @InjectMocks
//    Borrower borrower;
//
//    @Mock
//    BorrowerRepository borrowerRepository;
//
//    @Mock
//    List<Payment> paymentList;
//
//    @Mock
//    PaymentRepository paymentRepository;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testGetCommand() throws Exception{
//        commandHandler.getCommand("LOAN IDIDI Dale 5000 1 6");
//        Mockito.when(borrowerRepository.findByBankNameAndBorrowerName("IDIDI", "Dale")).thenReturn(borrower);
//
//        commandHandler.getCommand("PAYMENT IDIDI Dale 1000 5");
//        Mockito.when(paymentRepository.findByBankNameEqualsAndBorrowerNameEqualsAndLastLumpSumEmiNoLessThanEqual("IDIDI", "Dale", 5)).thenReturn(paymentList);
//    }
//}
