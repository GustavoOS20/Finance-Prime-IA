package com.gustavo.FinancePrimeIA.entity;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AIAnalysis {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @Column(nullable = false)
    private LocalDate referenceMonth;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String summaryText;

    @Column(nullable = false)
    private BigDecimal totalIncome;

    @Column(nullable = false)
    private BigDecimal totalExpenseDebit;

    @Column(nullable = false)
    private BigDecimal totalExpenseCredit;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;
}
