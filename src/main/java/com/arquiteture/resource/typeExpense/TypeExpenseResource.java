package com.arquiteture.resource.typeExpense;

import com.arquiteture.core.mapper.IBaseMapper;
import com.arquiteture.core.resource.BaseResource;
import com.arquiteture.core.service.IBaseService;
import com.arquiteture.domain.entity.TypeExpense;
import com.arquiteture.domain.model.typeExpense.ITypeExpenseMapper;
import com.arquiteture.domain.model.typeExpense.TypeExpenseRequestDTO;
import com.arquiteture.domain.model.typeExpense.TypeExpenseResponseDTO;
import com.arquiteture.domain.service.typeExpense.ITypeExpenseService;
import jakarta.ws.rs.Path;

@Path("/type-expense")
public class TypeExpenseResource extends BaseResource<TypeExpense, TypeExpenseRequestDTO, TypeExpenseResponseDTO> {
    protected TypeExpenseResource(final ITypeExpenseService service, final ITypeExpenseMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected ITypeExpenseMapper getMapper() {
        return (ITypeExpenseMapper) super.getMapper();
    }

    @Override
    protected ITypeExpenseService getService() {
        return (ITypeExpenseService) super.getService();
    }
}
