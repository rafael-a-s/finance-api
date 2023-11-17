package com.arquiteture.domain.service.financeControl;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.FinanceControl;
import com.arquiteture.domain.repository.FinanceControlRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Objects;

@ApplicationScoped
public class FinanceControlService extends BaseService<FinanceControl> implements IFinanceControlService {

    protected FinanceControlService(final FinanceControlRepository repository) {
        super(repository);
    }

    public FinanceControlService() {}

    @Override
    public FinanceControl initializeFinanceControlInDataBase() throws DomainException {

        FinanceControl entity = new FinanceControl();
        getRepository().persist(entity);

        if (Objects.isNull(entity.getId())){
            throw new DomainException("Ocorreu um erro.");
        }

        return entity;
    }

    @Override
    public FinanceControlRepository getRepository() {
        return (FinanceControlRepository) super.getRepository();
    }
}
