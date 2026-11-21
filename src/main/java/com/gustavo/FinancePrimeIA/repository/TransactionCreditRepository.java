package com.gustavo.FinancePrimeIA.repository;

import com.gustavo.FinancePrimeIA.entity.TransactionCredit;
import com.gustavo.FinancePrimeIA.entity.enums.TransactionCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionCreditRepository extends JpaRepository<TransactionCredit, UUID> {

    Page<TransactionCredit> findByUsersId(UUID userId, Pageable pageable);

    Optional<TransactionCredit> findByIdAndUsersId(UUID id, UUID userId);

    List<TransactionCredit> findByUsersIdAndBillingMonth(UUID userId, YearMonth billingMonth);

    List<TransactionCredit> findByUsersIdAndCardNameAndBillingMonth(
            UUID userId, String cardName, YearMonth billingMonth);

    List<TransactionCredit> findByUsersIdAndCategoryAndBillingMonth(
            UUID userId, TransactionCategory category, YearMonth billingMonth);

    @Query("""
            SELECT t
            FROM TransactionCredit t
            WHERE t.users.id = :userId
              AND t.billingMonth = :billingMonth
              AND t.isPaid = :paid
            """)
    List<TransactionCredit> findByUserAndBillingMonthAndPaidStatus(
            @Param("userId") UUID userId,
            @Param("billingMonth") YearMonth billingMonth,
            @Param("paid") boolean paid);

    @Query("""
            SELECT COALESCE(SUM(t.amount), CAST(0 AS BigDecimal))
            FROM TransactionCredit t
            WHERE t.users.id = :userId
              AND t.billingMonth = :billingMonth
            """)
    BigDecimal sumAmountByUserAndBillingMonth(
            @Param("userId") UUID userId,
            @Param("billingMonth") YearMonth billingMonth);
}
