package com.arquiteture.resource.financeControl;

import com.arquiteture.core.resource.BaseResource;
import com.arquiteture.domain.entity.FinanceControl;
import com.arquiteture.domain.model.financeControl.FinanceControlRequestDTO;
import com.arquiteture.domain.model.financeControl.FinanceControlResponseDTO;
import com.arquiteture.domain.model.financeControl.IFinanceControlMapper;
import com.arquiteture.domain.service.financeControl.FinanceControlService;
import com.arquiteture.domain.service.financeControl.IFinanceControlService;
import jakarta.ws.rs.Path;

@Path("/finance-control")
public class FinanceControlResource extends BaseResource<FinanceControl, FinanceControlRequestDTO, FinanceControlResponseDTO> {
    protected FinanceControlResource(final IFinanceControlService service, IFinanceControlMapper mapper) {
        super(service, mapper);
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
