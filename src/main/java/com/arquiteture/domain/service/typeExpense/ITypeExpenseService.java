package com.arquiteture.domain.service.typeExpense;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.service.IBaseService;
import com.arquiteture.domain.entity.TypeExpense;

public interface ITypeExpenseService extends IBaseService<TypeExpense> {

    void removeExpense(String id) throws DomainException;
}