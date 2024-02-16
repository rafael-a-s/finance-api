package com.arquiteture.domain.service.expense;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.Expense;
import com.arquiteture.domain.model.expense.ExpenseResponseDTO;
import com.arquiteture.domain.repository.ExpenseRepository;
import com.arquiteture.domain.service.financeControl.IFinanceControlService;
import com.arquiteture.domain.service.typeExpense.ITypeExpenseService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @Override
    public List<ExpenseResponseDTO> findAllExpenseOfTypeExpense(Function<Expense, ExpenseResponseDTO> convert, String idTypeExpense) {
        return getRepository()
                .findAllExpenseOfOneTypeExpense(idTypeExpense)
                .stream()
                .map(convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<Expense> findAllExpenseOfTypeExpense(String idTypeExpense) throws DomainException {
        return getRepository().findAllExpenseOfOneTypeExpense(idTypeExpense);
    }
}
