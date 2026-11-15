package com.gustavo.FinancePrimeIA.entity;

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
public class Investiment {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InvestimentType type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InvestimentOperation operation;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate date;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;
}

enum InvestimentType {
    EMERGENCY_RESERVE, FIXED_INCOME, STOCKS , FII, CRYPTO, FUNDS
}

enum InvestimentOperation {
    DEPOSIT, WITHDRAWAL
}
