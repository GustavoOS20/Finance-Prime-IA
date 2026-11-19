package com.gustavo.FinancePrimeIA.repository;

import com.gustavo.FinancePrimeIA.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
