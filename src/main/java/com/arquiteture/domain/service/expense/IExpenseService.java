package com.arquiteture.domain.service.expense;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.service.IBaseService;
import com.arquiteture.domain.entity.Expense;
import com.arquiteture.domain.model.expense.ExpenseResponseDTO;

import java.util.List;
import java.util.function.Function;

public interface IExpenseService extends IBaseService<Expense> {


    List<ExpenseResponseDTO> findAllExpenseOfTypeExpense(Function<Expense, ExpenseResponseDTO> convert, String idTypeExpense);
    List<Expense> findAllExpenseOfTypeExpense(String idTypeExpense) throws DomainException;
}
