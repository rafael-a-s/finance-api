package com.arquiteture.domain.model.remuneration;

import com.arquiteture.core.mapper.IBaseMapper;
import com.arquiteture.domain.entity.Remuneration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "jakarta", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRemunerationMapper extends IBaseMapper<Remuneration, RemunerationRequestDTO, RemunerationResponseDTO> {
}
