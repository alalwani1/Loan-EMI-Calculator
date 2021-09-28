package com.assignment.ledger.repository;

import com.assignment.ledger.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByBankNameEqualsAndBorrowerNameEqualsAndLastLumpSumEmiNoLessThanEqual(String bankName, String borrowerName, int lastLumpSumEmiNo);
}