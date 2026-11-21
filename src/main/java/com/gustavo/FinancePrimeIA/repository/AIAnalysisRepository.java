package com.gustavo.FinancePrimeIA.repository;

import com.gustavo.FinancePrimeIA.entity.AIAnalysis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AIAnalysisRepository extends JpaRepository<AIAnalysis, UUID> {

    List<AIAnalysis> findByUsersIdOrderByReferenceMonthDesc(UUID userId);

    Page<AIAnalysis> findByUsersId(UUID userId, Pageable pageable);

    Optional<AIAnalysis> findByIdAndUsersId(UUID id, UUID userId);

    Optional<AIAnalysis> findByUsersIdAndReferenceMonth(UUID userId, LocalDate referenceMonth);

    boolean existsByUsersIdAndReferenceMonth(UUID userId, LocalDate referenceMonth);
}
