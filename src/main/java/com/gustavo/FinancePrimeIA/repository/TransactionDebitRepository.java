package com.gustavo.FinancePrimeIA.repository;

import com.gustavo.FinancePrimeIA.entity.TransactionDebit;
import com.gustavo.FinancePrimeIA.entity.enums.TransactionCategory;
import com.gustavo.FinancePrimeIA.entity.enums.TransactionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionDebitRepository extends JpaRepository<TransactionDebit, UUID> {

    Page<TransactionDebit> findByUsersId(UUID userId, Pageable pageable);

    Optional<TransactionDebit> findByIdAndUsersId(UUID id, UUID userId);

    List<TransactionDebit> findByUsersIdAndTransactionDateBetween(
            UUID userId, LocalDate startDate, LocalDate endDate);

    List<TransactionDebit> findByUsersIdAndTypeAndTransactionDateBetween(
            UUID userId, TransactionType type, LocalDate startDate, LocalDate endDate);

    List<TransactionDebit> findByUsersIdAndCategoryAndTransactionDateBetween(
            UUID userId, TransactionCategory category, LocalDate startDate, LocalDate endDate);

    @Query("""
            SELECT COALESCE(SUM(t.amount), CAST(0 AS BigDecimal))
            FROM TransactionDebit t
            WHERE t.users.id = :userId
              AND t.type = :type
              AND t.transactionDate BETWEEN :startDate AND :endDate
            """)
    BigDecimal sumAmountByUserAndTypeAndPeriod(
            @Param("userId") UUID userId,
            @Param("type") TransactionType type,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
