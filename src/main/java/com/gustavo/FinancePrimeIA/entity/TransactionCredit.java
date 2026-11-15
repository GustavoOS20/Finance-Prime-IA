package com.gustavo.FinancePrimeIA.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.UUID;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TransactionCredit")
public class TransactionCredit {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    private String cardName;

    @Column(nullable = false)
    private BigDecimal amount;

    @Builder.Default
    @Column(nullable = false)
    private Integer installmentsNumber = 1;

    @Builder.Default
    @Column(nullable = false)
    private Integer totalInstallments = 1;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionCategory category;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;

    @Column(nullable = false)
    private YearMonth billingMonth;

    @Builder.Default
    @Column(nullable = false)
    private boolean isPaid = false;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;
}
