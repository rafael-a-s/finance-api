package com.arquiteture.domain.model.expense;

import com.arquiteture.domain.model.typeExpense.TypeExpenseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponseDTO {

    private String id;
    private String name;
    private Integer dayDiscount;
    private Double value;
    private TypeExpenseResponseDTO typeExpense;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private boolean active;
}
