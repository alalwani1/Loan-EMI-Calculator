package com.assignment.ledger.repository;

import com.assignment.ledger.domain.Borrower;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BorrowerRepositoryTest {

    @Mock
    BorrowerRepository borrowerRepository;

    @InjectMocks
    Borrower borrower;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByBankNameAndBorrowerNameTest() throws Exception{
        Mockito.when(borrowerRepository.findByBankNameAndBorrowerName("MBI", "Harry")).thenReturn(borrower);
    }
}
