package com.arquiteture.domain.service.typeExpense;

import com.arquiteture.core.repository.IBaseRepository;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.Remuneration;
import com.arquiteture.domain.entity.TypeExpense;
import com.arquiteture.domain.repository.RemunerationRepository;
import com.arquiteture.domain.repository.TypeExpenseRepository;
import com.arquiteture.domain.service.remuneration.IRemunerationService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TypeExpenseService extends BaseService<TypeExpense> implements ITypeExpenseService {

    protected TypeExpenseService (final TypeExpenseRepository repository){
        super(repository);
    }

    public TypeExpenseService(){}

    @Override
    public TypeExpenseRepository getRepository() {
        return (TypeExpenseRepository) super.getRepository();
    }
}
