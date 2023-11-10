package com.arquiteture.domain.model.user;

import com.arquiteture.core.mapper.IBaseMapper;
import com.arquiteture.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "jakarta", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper extends IBaseMapper<User, UserRequestDTO, UserResponseDTO> {
}
