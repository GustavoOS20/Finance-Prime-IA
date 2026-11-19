package com.gustavo.FinancePrimeIA.dto.dto_entry;

import com.gustavo.FinancePrimeIA.entity.Users;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AIAnalysisDTOEntry(
    Users users,
    LocalDate referenceMonth,
    String summaryText,
    BigDecimal totalIncome,
    BigDecimal totalExpenseDebit,
    BigDecimal totalExpenseCredit
) {
}
