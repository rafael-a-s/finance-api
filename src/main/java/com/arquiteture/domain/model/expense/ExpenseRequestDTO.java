package com.arquiteture.domain.model.expense;

import com.arquiteture.core.entity.BaseEntityRequest;
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
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequestDTO {

    @NotBlank(message = "validation.field.not-blank")
    @NotNull(message = "validation.field.not-null")
    @Min(value = 2, message = "validation.expense.name.size.min")
    @Max(value = 50, message = "validation.expense.name.size.max")
    private String name;

    @NotBlank(message = "validation.field.not-blank")
    @NotNull(message = "validation.field.not-null")
    @Min(value = 1, message = "validation.expense.dayDiscount.size.min")
    @Max(value = 2, message = "validation.expense.dayDiscount.size.max")
    private Integer dayDiscount;

    @NotBlank(message = "validation.field.not-blank")
    @NotNull(message = "validation.field.not-null")
    private BigDecimal value;

    @NotBlank(message = "validation.field.not-blank")
    @NotNull(message = "validation.field.not-null")
    private BaseEntityRequest typeExpense;
}
