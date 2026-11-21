package com.gustavo.FinancePrimeIA.repository;

import com.gustavo.FinancePrimeIA.entity.Investiment;
import com.gustavo.FinancePrimeIA.entity.enums.InvestimentOperation;
import com.gustavo.FinancePrimeIA.entity.enums.InvestimentType;
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

public interface InvestimentRepository extends JpaRepository<Investiment, UUID> {

    Page<Investiment> findByUsersId(UUID userId, Pageable pageable);

    Optional<Investiment> findByIdAndUsersId(UUID id, UUID userId);

    List<Investiment> findByUsersIdAndType(UUID userId, InvestimentType type);

    List<Investiment> findByUsersIdAndOperation(UUID userId, InvestimentOperation operation);

    List<Investiment> findByUsersIdAndDateBetween(UUID userId, LocalDate startDate, LocalDate endDate);

    @Query("""
            SELECT COALESCE(SUM(
                CASE
                    WHEN i.operation = com.gustavo.FinancePrimeIA.entity.enums.InvestimentOperation.DEPOSIT THEN i.amount
                    WHEN i.operation = com.gustavo.FinancePrimeIA.entity.enums.InvestimentOperation.WITHDRAWAL THEN -i.amount
                    ELSE CAST(0 AS BigDecimal)
                END
            ), CAST(0 AS BigDecimal))
            FROM Investiment i
            WHERE i.users.id = :userId
            """)
    BigDecimal calculateTotalBalanceByUser(@Param("userId") UUID userId);

    @Query("""
            SELECT COALESCE(SUM(
                CASE
                    WHEN i.operation = com.gustavo.FinancePrimeIA.entity.enums.InvestimentOperation.DEPOSIT THEN i.amount
                    WHEN i.operation = com.gustavo.FinancePrimeIA.entity.enums.InvestimentOperation.WITHDRAWAL THEN -i.amount
                    ELSE CAST(0 AS BigDecimal)
                END
            ), CAST(0 AS BigDecimal))
            FROM Investiment i
            WHERE i.users.id = :userId
              AND i.type = :type
            """)
    BigDecimal calculateTotalBalanceByUserAndType(
            @Param("userId") UUID userId,
            @Param("type") InvestimentType type);
}
