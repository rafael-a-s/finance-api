package com.arquiteture.domain.model.typeExpense;

import com.arquiteture.core.mapper.IBaseMapper;
import com.arquiteture.domain.entity.TypeExpense;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "jakarta", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITypeExpenseMapper extends IBaseMapper<TypeExpense, TypeExpenseRequestDTO, TypeExpenseResponseDTO> {
}
