package com.arquiteture.resource.user;

import com.arquiteture.core.resource.BaseResource;
import com.arquiteture.domain.entity.User;
import com.arquiteture.domain.model.user.IUserMapper;
import com.arquiteture.domain.model.user.UserRequestDTO;
import com.arquiteture.domain.model.user.UserResponseDTO;
import com.arquiteture.domain.service.user.IUserService;
import jakarta.ws.rs.Path;

@Path("/user")
public class UserResource extends BaseResource<User, UserRequestDTO, UserResponseDTO> {

    protected UserResource(final IUserService service, final IUserMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected IUserMapper getMapper() {
        return (IUserMapper) super.getMapper();
    }

    @Override
    protected IUserService getService() {
        return (IUserService) super.getService();
    }
}
