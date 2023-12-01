package com.arquiteture.domain.entity;

import com.arquiteture.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;

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

    @OneToMany(targetEntity = Remuneration.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Remuneration> remunerations;

    @OneToMany(targetEntity = Expense.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expensesFixes;

    @OneToMany(targetEntity = MonthlyContribution.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MonthlyContribution> monthlyContributions;

    @OneToOne(mappedBy = "financeControl", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    public Double getRemunerationMonth() {

        return this.remunerations
                .stream()
                .map(Remuneration::getValue)
                .reduce(Double.MIN_VALUE, Double::sum);
    }

    public Double getTotalExpenseFixedMonth() {

        return this.expensesFixes
                .stream()
                .map(Expense::getValue)
                .reduce(Double.MIN_VALUE, Double::sum);
    }

    public Double getInvestimentMonth() {

        return this.monthlyContributions
                .stream()
                .map(MonthlyContribution::getValue)
                .reduce(Double.MIN_VALUE, Double::sum);
    }

    public Double getSubTotalMonth() {

        Double totalRemuneration = getRemunerationMonth();
        Double totalExpenses = getTotalExpenseFixedMonth();
        Double totalInvestments = getInvestimentMonth();

        Double totalMonthlySpending = totalExpenses = totalInvestments;

        return totalRemuneration - totalMonthlySpending;
    }

    public Double getTotalToSpendForTheWeek() {
        LocalDate firstDayOfMonth = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
        LocalDate lastDayOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());

        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        int weekNumberStart = firstDayOfMonth.get(weekFields.weekOfYear());
        int weekNumberEnd = lastDayOfMonth.get(weekFields.weekOfYear());

        int totalWeek = weekNumberEnd - weekNumberStart + 1;

        return getSubTotalMonth() / totalWeek;
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
