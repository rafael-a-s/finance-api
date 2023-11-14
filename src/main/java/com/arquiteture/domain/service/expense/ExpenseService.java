package com.arquiteture.domain.service.expense;

import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.Expense;
import com.arquiteture.domain.repository.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExpenseService extends BaseService<Expense> implements IExpenseService {

    protected ExpenseService(final ExpenseRepository repository) {
        super(repository);
    }

    public ExpenseService() {
    }

    @Override
    public ExpenseRepository getRepository() {
        return (ExpenseRepository) super.getRepository();
    }
}
