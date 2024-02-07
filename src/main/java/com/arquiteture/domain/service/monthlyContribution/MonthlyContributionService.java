package com.arquiteture.domain.service.monthlyContribution;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.repository.IBaseRepository;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.MonthlyContribution;
import com.arquiteture.domain.repository.MonthlyContributionRepository;
import com.arquiteture.domain.service.financeControl.IFinanceControlService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MonthlyContributionService extends BaseService<MonthlyContribution> implements IMonthlyContributionService {

    @Inject
    IFinanceControlService financeControlService;

    protected MonthlyContributionService(final MonthlyContributionRepository repository) {
        super(repository);
    }

    public MonthlyContributionService() {}

    @Override
    public MonthlyContribution create(MonthlyContribution entity) throws DomainException {
        validate(entity);
        getRepository().persist(entity);

        financeControlService.addMonthlyContribution(entity);

        return entity;
    }

    @Override
    public List<MonthlyContribution> listAll() throws DomainException{
        return financeControlService.getAllMonthlyContibutionOfUserUsingSubject();
    }

    @Override
    public MonthlyContributionRepository getRepository() {
        return (MonthlyContributionRepository) super.getRepository();
    }
}
