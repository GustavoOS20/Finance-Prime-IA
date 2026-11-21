package com.gustavo.FinancePrimeIA.repository;

import com.gustavo.FinancePrimeIA.entity.Users;
import com.gustavo.FinancePrimeIA.entity.enums.AuthProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByEmailAndActiveTrue(String email);

    boolean existsByEmail(String email);

    Optional<Users> findByProviderAndProviderId(AuthProvider provider, String providerId);
}
