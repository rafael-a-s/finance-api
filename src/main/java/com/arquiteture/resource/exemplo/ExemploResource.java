package com.arquiteture.resource.exemplo;

import com.arquiteture.core.resource.BaseResource;
import com.arquiteture.domain.entity.Exemplo;
import com.arquiteture.domain.model.exemplo.ExemploRequestDTO;
import com.arquiteture.domain.model.exemplo.ExemploResponseDTO;
import com.arquiteture.domain.model.exemplo.IExemploMapper;
import com.arquiteture.domain.service.exemplo.IExemploService;
import jakarta.ws.rs.Path;

@Path("/exemplo")
public class ExemploResource extends BaseResource<Exemplo, ExemploRequestDTO, ExemploResponseDTO> {

    protected ExemploResource(final IExemploService service, IExemploMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected IExemploMapper getMapper() {
        return (IExemploMapper) super.getMapper();
    }

    @Override
    protected IExemploService getService() {
        return (IExemploService) super.getService();
    }
}
