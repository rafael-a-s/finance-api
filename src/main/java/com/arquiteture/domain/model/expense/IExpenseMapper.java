package com.arquiteture.domain.model.expense;

import com.arquiteture.core.mapper.IBaseMapper;
import com.arquiteture.domain.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel ="jakarta", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IExpenseMapper extends IBaseMapper<Expense, ExpenseRequestDTO, ExpenseResponseDTO> {
}
