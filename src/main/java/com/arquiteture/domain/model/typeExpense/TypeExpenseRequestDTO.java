package com.arquiteture.domain.model.typeExpense;

import jakarta.validation.constraints.*;
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
    @Size(min = 2, max = 50, message = "{validation.typeExpense.nameOfExpense.size}")
    private String nameOfExpense;
}