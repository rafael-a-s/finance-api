package com.arquiteture.resource.expense;

import com.arquiteture.core.resource.BaseResource;
import com.arquiteture.domain.entity.Expense;
import com.arquiteture.domain.model.expense.ExpenseRequestDTO;
import com.arquiteture.domain.model.expense.ExpenseResponseDTO;
import com.arquiteture.domain.model.expense.IExpenseMapper;
import com.arquiteture.domain.service.expense.IExpenseService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Path;

@Path("/expense")
@RolesAllowed({"user", "admin"})
public class ExpenseResource extends BaseResource<Expense, ExpenseRequestDTO, ExpenseResponseDTO> {
    protected ExpenseResource(final IExpenseService service, final IExpenseMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected IExpenseMapper getMapper() {
        return (IExpenseMapper) super.getMapper();
    }

    @Override
    protected IExpenseService getService() {
        return (IExpenseService) super.getService();
    }
}
