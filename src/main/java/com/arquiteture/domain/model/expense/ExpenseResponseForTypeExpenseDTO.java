package com.arquiteture.domain.model.expense;

import com.arquiteture.domain.model.typeExpense.TypeExpenseResponseForExpenseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponseForTypeExpenseDTO {

    private String id;
    private String name;
    private String dayDiscount;
    private Double value;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private boolean active;
}
