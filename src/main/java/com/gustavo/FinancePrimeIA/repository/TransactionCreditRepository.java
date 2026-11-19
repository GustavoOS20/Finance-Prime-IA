package com.gustavo.FinancePrimeIA.repository;

import com.gustavo.FinancePrimeIA.entity.TransactionCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionCreditRepository extends JpaRepository<TransactionCredit, Integer> {
}
