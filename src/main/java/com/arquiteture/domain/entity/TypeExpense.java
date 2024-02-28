package com.arquiteture.domain.entity;

import com.arquiteture.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_expense")
public class TypeExpense extends BaseEntity {

    @Id
    @Column(name = "type_expense_id")
    private String id;

    @Column(name = "name_type_expense")
    private String nameOfExpense;

    @OneToMany(targetEntity = Expense.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "typeExpense", orphanRemoval = true)
    private List<Expense> expenses;

    public Double getTotalExpense() {
        return this.getExpenses()
                .stream()
                .map(Expense::getValue)
                .reduce(Double.MIN_VALUE, Double::sum);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}