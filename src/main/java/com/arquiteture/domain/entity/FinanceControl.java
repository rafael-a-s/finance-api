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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "finance_control")
public class FinanceControl extends BaseEntity {

    @Id
    @Column(name = "finance_control_id")
    private String id;

    @OneToMany(targetEntity = Remuneration.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "finance_control")
    private List<Remuneration> remunerations;

    @OneToMany(targetEntity = Expense.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "finance_control", orphanRemoval = true)
    private List<Expense> expensesFixes;

    @OneToMany(targetEntity = MonthlyContribution.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "finance_control", orphanRemoval = true)
    private List<MonthlyContribution> monthlyContributions;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
