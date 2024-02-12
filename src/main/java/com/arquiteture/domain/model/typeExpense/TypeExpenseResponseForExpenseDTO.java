package com.arquiteture.domain.model.typeExpense;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

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
