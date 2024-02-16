package com.arquiteture.domain.repository;

import com.arquiteture.core.repository.IBaseRepository;
import com.arquiteture.domain.entity.Expense;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ExpenseRepository implements IBaseRepository<Expense> {

    public List<Expense> findAllExpenseOfOneTypeExpense(String idTypeExpense) {
        return find("typeExpense.id = ?1", idTypeExpense).stream().toList();
    }
}
