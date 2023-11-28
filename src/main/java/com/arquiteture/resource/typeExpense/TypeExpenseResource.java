package com.arquiteture.resource.typeExpense;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.resource.BaseResource;
import com.arquiteture.domain.entity.TypeExpense;
import com.arquiteture.domain.model.typeExpense.ITypeExpenseMapper;
import com.arquiteture.domain.model.typeExpense.TypeExpenseRequestDTO;
import com.arquiteture.domain.model.typeExpense.TypeExpenseResponseDTO;
import com.arquiteture.domain.service.typeExpense.ITypeExpenseService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/type-expense")
@RolesAllowed({"user", "admin"})
public class TypeExpenseResource extends BaseResource<TypeExpense, TypeExpenseRequestDTO, TypeExpenseResponseDTO> {
    protected TypeExpenseResource(final ITypeExpenseService service, final ITypeExpenseMapper mapper) {
        super(service, mapper);
    }

    @Path("/v1/remove-expense/{id}")
    @DELETE
    public Response removeExpense(@PathParam("id") String id) throws DomainException {

        getService().removeExpense(id);
        return Response.noContent().build();
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
