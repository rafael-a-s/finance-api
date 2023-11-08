package com.arquiteture.domain.model.exemplo;

import com.arquiteture.core.mapper.IBaseMapper;
import com.arquiteture.domain.entity.Exemplo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "jakarta", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IExemploMapper extends IBaseMapper<Exemplo, ExemploRequestDTO,  ExemploResponseDTO> {
}
