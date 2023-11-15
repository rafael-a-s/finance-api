package com.arquiteture.domain.model.monthlyContribution;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonthlyContributionResponseDTO {

    private String id;
    private String nameInvestiment;
    private BigDecimal value;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private boolean active;
}
