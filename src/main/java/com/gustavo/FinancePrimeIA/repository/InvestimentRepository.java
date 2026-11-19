package com.gustavo.FinancePrimeIA.repository;

import com.gustavo.FinancePrimeIA.entity.Investiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestimentRepository extends JpaRepository<Investiment, Integer> {
}
