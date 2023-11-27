package com.arquiteture.domain.model.typeExpense;

import com.arquiteture.domain.entity.Expense;
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
public class TypeExpenseResponseForExpenseDTO {

    private String id;
    private String nameOfExpense;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private boolean active;
}
