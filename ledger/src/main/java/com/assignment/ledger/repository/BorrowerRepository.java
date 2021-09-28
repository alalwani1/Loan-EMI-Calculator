package com.assignment.ledger.repository;

import com.assignment.ledger.domain.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    Borrower findByBankNameAndBorrowerName(String bankName, String borrowerName);
}