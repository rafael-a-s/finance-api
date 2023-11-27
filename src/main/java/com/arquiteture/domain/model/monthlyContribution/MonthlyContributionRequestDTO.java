package com.arquiteture.domain.model.monthlyContribution;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyContributionRequestDTO {

    @NotBlank(message = "{validation.field.not-blank}")
    @NotNull(message = "{validation.field.not-null}")
    @Size(min = 2, max = 50, message = "{validation.monthly-contribution.nameInvestiment.size}")
    private String nameInvestiment;

    @NotNull(message = "{validation.field.not-null}")
    private Double value;
}
