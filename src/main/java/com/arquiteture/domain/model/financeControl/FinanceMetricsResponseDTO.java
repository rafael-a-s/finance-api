package com.arquiteture.domain.model.financeControl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinanceMetricsResponseDTO {
    private Double totalRemuneration;
    private Double totalInvestimentMonth;
    private Double subTotalForMonth;
    private Double totalSpendForWeek;
    private Double totalExpenses;
}
