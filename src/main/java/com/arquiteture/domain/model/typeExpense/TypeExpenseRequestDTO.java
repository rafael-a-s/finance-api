package com.arquiteture.domain.model.typeExpense;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeExpenseRequestDTO {

    @NotBlank(message = "validation.field.not-blank")
    @NotNull(message = "validation.field.not-null")
    @Min(value = 2, message = "validation.typeExpense.nameOfExpense.size.min")
    @Max(value = 50, message = "validation.typeExpense.nameOfExpense.size.max")
    private String nameOfExpense;
}