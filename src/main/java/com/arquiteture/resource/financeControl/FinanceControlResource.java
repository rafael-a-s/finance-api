package com.arquiteture.resource.financeControl;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.resource.BaseResource;
import com.arquiteture.domain.entity.FinanceControl;
import com.arquiteture.domain.model.financeControl.FinanceControlRequestDTO;
import com.arquiteture.domain.model.financeControl.FinanceControlResponseDTO;
import com.arquiteture.domain.model.financeControl.IFinanceControlMapper;
import com.arquiteture.domain.service.financeControl.FinanceControlService;
import com.arquiteture.domain.service.financeControl.IFinanceControlService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("/finance-control")
@RolesAllowed({"user", "admin"})
public class FinanceControlResource extends BaseResource<FinanceControl, FinanceControlRequestDTO, FinanceControlResponseDTO> {
    protected FinanceControlResource(final IFinanceControlService service, IFinanceControlMapper mapper) {
        super(service, mapper);
    }

    @POST
    @Path("/v1/initialize")
    public Response intialize() throws DomainException {

        var entity = getService().initializeFinanceControlInDataBase();
        var location = URI.create("/finance-control/" + entity.getId());
        return Response.created(location).build();
    }

    @Path("/v1/metrics")
    @GET
    public Response metrics() throws DomainException {
        var financeControlMetrics = getService().financeControlMetrics();
        return Response.ok(financeControlMetrics).build();
    }

    @Override
    protected FinanceControlService getService() {
        return (FinanceControlService) super.getService();
    }

    @Override
    protected IFinanceControlMapper getMapper() {
        return (IFinanceControlMapper) super.getMapper();
    }
}
