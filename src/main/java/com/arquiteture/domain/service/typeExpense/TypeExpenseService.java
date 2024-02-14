package com.arquiteture.domain.service.typeExpense;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.TypeExpense;
import com.arquiteture.domain.repository.TypeExpenseRepository;
import com.arquiteture.domain.service.expense.IExpenseService;
import com.arquiteture.domain.service.financeControl.IFinanceControlService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TypeExpenseService extends BaseService<TypeExpense> implements ITypeExpenseService {

    @Inject
    IExpenseService expenseService;

    @Inject
    IFinanceControlService financeControlService;

    protected TypeExpenseService (final TypeExpenseRepository repository){
        super(repository);
    }

    public TypeExpenseService(){}

    @Override
    public TypeExpenseRepository getRepository() {
        return (TypeExpenseRepository) super.getRepository();
    }

    @Override
    public TypeExpense create(TypeExpense entity) throws DomainException {
        validate(entity);
        getRepository().persist(entity);

        financeControlService.addTypeExpense(entity);

        return entity;
    }

    @Override
    @Transactional
    public void removeExpense(String id) throws DomainException {
        var expenseForRemove = expenseService.findById(id);
        var typeExpense = getRepository().findByIdOptional(expenseForRemove.getTypeExpense().getId()).orElseThrow(() -> new DomainException("TypeExpense not found!"));

        typeExpense.getExpenses().removeIf(expense -> expense.getId().equals(expenseForRemove.getId()));

        this.update(typeExpense.getId(), typeExpense);
    }
}
