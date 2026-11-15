package com.gustavo.FinancePrimeIA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "users_id", nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthProvider provider;

    @Column(nullable = true, name = "provider_id")
    private String providerId;

    @Column(nullable = true, name = "picture_url")
    private String pictureUrl;

    @Builder.Default
    @Column(nullable = false)
    private boolean active = true;

    @Builder.Default
    @Column(nullable = false, name = "email_verified")
    private boolean emailVerified = false;

    @Column(nullable = false)
    private BigDecimal monthlyIncome;

    @Column(nullable = false)
    private BigDecimal monthlyExpenseLimit;

    @Column(nullable = false)
    private Integer creditCardClosingDay;
}

enum AuthProvider {
    LOCAL,
    GOOGLE
}
