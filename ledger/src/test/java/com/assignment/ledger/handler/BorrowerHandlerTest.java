package com.assignment.ledger.handler;

import com.assignment.ledger.domain.Borrower;
import com.assignment.ledger.repository.BorrowerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BorrowerHandlerTest {

    @InjectMocks
    BorrowerHandler borrowerHandler;

    @InjectMocks
    Borrower borrower;

    @Mock
    BorrowerRepository borrowerRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testStoreBorrowerInformationIntoDB() throws Exception{

        borrowerHandler.storeBorrowerInformationIntoDB("ICICI", "Harry", 15000L, 2,
                9, 0);
        Mockito.when(borrowerRepository.findByBankNameAndBorrowerName("ICICI", "Harry")).thenReturn(borrower);
    }
}
