package com.arquiteture.domain.model.financeControl;

import com.arquiteture.core.mapper.IBaseMapper;
import com.arquiteture.domain.entity.FinanceControl;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "jakarta", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IFinanceControlMapper extends IBaseMapper<FinanceControl, FinanceControlRequestDTO, FinanceControlResponseDTO> {
}
