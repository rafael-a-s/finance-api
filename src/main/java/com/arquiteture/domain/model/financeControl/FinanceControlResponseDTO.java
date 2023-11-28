package com.arquiteture.domain.model.financeControl;

import com.arquiteture.domain.model.expense.ExpenseResponseDTO;
import com.arquiteture.domain.model.monthlyContribution.MonthlyContributionResponseDTO;
import com.arquiteture.domain.model.remuneration.RemunerationResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinanceControlResponseDTO {

    private String id;
    private List<RemunerationResponseDTO> remunerations;
    private List<ExpenseResponseDTO> expensesFixes;
    private List<MonthlyContributionResponseDTO> monthlyContributions;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private boolean active;
}
