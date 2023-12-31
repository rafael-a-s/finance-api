package com.arquiteture.domain.model.expense;

import com.arquiteture.domain.model.typeExpense.TypeExpenseResponseForExpenseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponseDTO {

    private String id;
    private String name;
    private String dayDiscount;
    private Double value;
    private TypeExpenseResponseForExpenseDTO typeExpense;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private boolean active;
}
