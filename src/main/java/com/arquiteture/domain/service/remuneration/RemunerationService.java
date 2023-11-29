package com.arquiteture.domain.service.remuneration;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.repository.IBaseRepository;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.Remuneration;
import com.arquiteture.domain.repository.RemunerationRepository;
import com.arquiteture.domain.service.financeControl.IFinanceControlService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RemunerationService extends BaseService<Remuneration> implements IRemunerationService {

    @Inject
    IFinanceControlService financeControlService;

    protected RemunerationService (final IBaseRepository<Remuneration> repository){
        super(repository);
    }

    public RemunerationService(){}

    @Override
    public Remuneration create(Remuneration entity) throws DomainException {
        validate(entity);
        getRepository().persist(entity);

        financeControlService.addRemuneration(entity);

        return entity;
    }

    @Override
    public RemunerationRepository getRepository() {
        return (RemunerationRepository) super.getRepository();
    }
}
