package com.arquiteture.domain.model.expense;

import com.arquiteture.core.entity.BaseEntityRequest;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequestDTO {

    @NotBlank(message = "{validation.field.not-blank}")
    @NotNull(message = "{validation.field.not-null}")
    @Size(min = 2, max = 50, message = "{validation.expense.name.size}")
    private String name;

    @NotNull(message = "{validation.field.not-null}")
    @NotBlank(message = "{validation.field.not-blank}")
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])$", message = "{validation.expense.dayDiscount.regex}")
    private String dayDiscount;

    @Positive(message = "{validation.field.positive}")
    @NotNull(message = "{validation.field.not-null}")
    private Double value;

    @NotNull(message = "{validation.field.not-null}")
    private BaseEntityRequest typeExpense;
}
