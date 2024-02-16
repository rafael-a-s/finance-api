package com.arquiteture.resource.expense;

import com.arquiteture.core.resource.BaseResource;
import com.arquiteture.domain.entity.Expense;
import com.arquiteture.domain.model.expense.ExpenseRequestDTO;
import com.arquiteture.domain.model.expense.ExpenseResponseDTO;
import com.arquiteture.domain.model.expense.IExpenseMapper;
import com.arquiteture.domain.service.expense.IExpenseService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/expense")
@RolesAllowed({"user", "admin"})
public class ExpenseResource extends BaseResource<Expense, ExpenseRequestDTO, ExpenseResponseDTO> {
    protected ExpenseResource(final IExpenseService service, final IExpenseMapper mapper) {
        super(service, mapper);
    }

    @GET
    @Path("/v1/find-all-of-type-expense/{idTypeExpense}")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllExpenseOfOneTypeExpense(@PathParam("idTypeExpense") String idTypeExpense) {
        var expenses = getService().findAllExpenseOfTypeExpense(getMapper()::toResponse, idTypeExpense);

        return Response.ok(expenses).build();
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
