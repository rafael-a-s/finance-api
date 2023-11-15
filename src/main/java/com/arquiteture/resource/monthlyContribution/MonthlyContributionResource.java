package com.arquiteture.resource.monthlyContribution;

import com.arquiteture.core.resource.BaseResource;
import com.arquiteture.domain.entity.MonthlyContribution;
import com.arquiteture.domain.model.monthlyContribution.IMonthlyContributionMapper;
import com.arquiteture.domain.model.monthlyContribution.MonthlyContributionRequestDTO;
import com.arquiteture.domain.model.monthlyContribution.MonthlyContributionResponseDTO;
import com.arquiteture.domain.service.monthlyContribution.IMonthlyContributionService;
import jakarta.ws.rs.Path;

@Path("/monthly-contribution")
public class MonthlyContributionResource extends BaseResource<MonthlyContribution, MonthlyContributionRequestDTO, MonthlyContributionResponseDTO> {

    protected MonthlyContributionResource(final IMonthlyContributionService service, final IMonthlyContributionMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected IMonthlyContributionService getService() {
        return (IMonthlyContributionService) super.getService();
    }

    @Override
    protected IMonthlyContributionMapper getMapper() {
        return (IMonthlyContributionMapper) super.getMapper();
    }
}
