package com.arquiteture.domain.repository;

import com.arquiteture.core.repository.IBaseRepository;
import com.arquiteture.domain.entity.Expense;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExpenseRepository implements IBaseRepository<Expense> {
}
