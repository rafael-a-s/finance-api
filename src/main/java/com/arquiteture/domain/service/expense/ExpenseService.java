package com.arquiteture.domain.service.expense;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.Expense;
import com.arquiteture.domain.entity.TypeExpense;
import com.arquiteture.domain.repository.ExpenseRepository;
import com.arquiteture.domain.service.financeControl.IFinanceControlService;
import com.arquiteture.domain.service.typeExpense.ITypeExpenseService;
import com.arquiteture.domain.service.typeExpense.TypeExpenseService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ExpenseService extends BaseService<Expense> implements IExpenseService {

    @Inject
    IFinanceControlService financeControlService;

    protected ExpenseService(final ExpenseRepository repository, final ITypeExpenseService typeExpenseService) {
        super(repository);
    }

    public ExpenseService() {
    }

    @Override
    public Expense create(Expense entity) throws DomainException {
        validate(entity);
        getRepository().persist(entity);

        financeControlService.addExpense(entity);

        return entity;
    }

    @Override
    public void delete(String id) throws DomainException {
        throw new DomainException("Method blocked!");
    }

    @Override
    public ExpenseRepository getRepository() {
        return (ExpenseRepository) super.getRepository();
    }
}
