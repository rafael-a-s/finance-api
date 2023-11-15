package com.arquiteture.domain.model.monthlyContribution;

import com.arquiteture.core.mapper.IBaseMapper;
import com.arquiteture.domain.entity.MonthlyContribution;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "jakarta", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMonthlyContributionMapper extends IBaseMapper<MonthlyContribution, MonthlyContributionRequestDTO, MonthlyContributionResponseDTO> {
}
