package com.arquiteture.domain.entity;

import com.arquiteture.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expense")
public class Expense extends BaseEntity {

    @Id
    @Column(name = "expense_id")
    private String id;

    @Column(name = "expense_name")
    private String name;

    @Column(name = "day_discount")
    private String dayDiscount;

    @Column(name = "expense_value")
    private Double value;

    @ManyToOne(targetEntity = TypeExpense.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "type_expense_id", referencedColumnName = "type_expense_id")
    private TypeExpense typeExpense;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
