package com.gustavo.FinancePrimeIA.repository;

import com.gustavo.FinancePrimeIA.entity.Investiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentRepository extends JpaRepository<Investiment, Integer> {
}
