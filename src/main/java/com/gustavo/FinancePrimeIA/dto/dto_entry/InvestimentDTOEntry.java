package com.gustavo.FinancePrimeIA.dto.dto_entry;

import com.gustavo.FinancePrimeIA.entity.Users;
import com.gustavo.FinancePrimeIA.entity.enums.InvestimentOperation;
import com.gustavo.FinancePrimeIA.entity.enums.InvestimentType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvestimentDTOEntry(
        Users users,
        String name,
        InvestimentType type,
        InvestimentOperation operation,
        BigDecimal amount,
        LocalDate date
) {
}
