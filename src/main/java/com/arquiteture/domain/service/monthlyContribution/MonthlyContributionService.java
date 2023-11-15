package com.arquiteture.domain.service.monthlyContribution;

import com.arquiteture.core.repository.IBaseRepository;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.MonthlyContribution;
import com.arquiteture.domain.repository.MonthlyContributionRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MonthlyContributionService extends BaseService<MonthlyContribution> implements IMonthlyContributionService {

    protected MonthlyContributionService(final MonthlyContributionRepository repository) {
        super(repository);
    }

    public MonthlyContributionService() {}

    @Override
    public MonthlyContributionRepository getRepository() {
        return (MonthlyContributionRepository) super.getRepository();
    }
}
