package com.arquiteture.resource.remuneration;

import com.arquiteture.core.resource.BaseResource;
import com.arquiteture.domain.entity.Remuneration;
import com.arquiteture.domain.model.remuneration.IRemunerationMapper;
import com.arquiteture.domain.model.remuneration.RemunerationRequestDTO;
import com.arquiteture.domain.model.remuneration.RemunerationResponseDTO;
import com.arquiteture.domain.service.remuneration.IRemunerationService;
import jakarta.ws.rs.Path;

@Path("/remuneration")
public class RemunerationResource extends BaseResource<Remuneration, RemunerationRequestDTO, RemunerationResponseDTO> {
    protected RemunerationResource(final IRemunerationService service, final IRemunerationMapper mapper) {
        super(service, mapper);
    }
}
