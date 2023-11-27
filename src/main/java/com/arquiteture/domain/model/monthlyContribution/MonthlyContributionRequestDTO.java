package com.arquiteture.domain.model.monthlyContribution;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyContributionRequestDTO {

    @NotBlank(message = "{validation.field.not-blank}")
    @NotNull(message = "{validation.field.not-null}")
    @Min(value = 2, message = "{validation.monthly-contribution.nameInvestiment.size.min}")
    @Max(value = 50, message = "{validation.monthly-contribution.nameInvestiment.size.max}")
    private String nameInvestiment;

    @NotNull(message = "{validation.field.not-null}")
    private Double value;
}
