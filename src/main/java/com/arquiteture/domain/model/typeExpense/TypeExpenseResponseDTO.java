package com.arquiteture.domain.model.typeExpense;

import com.arquiteture.domain.entity.Expense;
import com.arquiteture.domain.model.expense.ExpenseResponseForTypeExpenseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeExpenseResponseDTO {

    private String id;
    private String nameOfExpense;
    private List<ExpenseResponseForTypeExpenseDTO> expenses;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private boolean active;
}
