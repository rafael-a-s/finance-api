package com.arquiteture.domain.model.financeControl;

import java.time.LocalDateTime;
import java.util.List;

import com.arquiteture.domain.model.expense.ExpenseResponseDTO;
import com.arquiteture.domain.model.monthlyContribution.MonthlyContributionResponseDTO;
import com.arquiteture.domain.model.remuneration.RemunerationResponseDTO;

import com.arquiteture.domain.model.typeExpense.TypeExpenseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinanceControlResponseNoUserDTO {
    private String id;
    private List<RemunerationResponseDTO> remunerations;
    private List<TypeExpenseResponseDTO> typeExpenses;
    private List<MonthlyContributionResponseDTO> monthlyContributions;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private boolean active;
}
