package com.arquiteture.resource.user;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.resource.BaseResource;
import com.arquiteture.domain.entity.User;
import com.arquiteture.domain.model.user.IUserMapper;
import com.arquiteture.domain.model.user.UserRequestDTO;
import com.arquiteture.domain.model.user.UserResponseDTO;
import com.arquiteture.domain.service.user.IUserService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends BaseResource<User, UserRequestDTO, UserResponseDTO> {

    protected UserResource(final IUserService service, final IUserMapper mapper) {
        super(service, mapper);
    }

    @POST
    @Path("/v1/register")
    @PermitAll
    public Response register(@Valid UserRequestDTO userRequestDTO) throws DomainException {

        var entity = getService().create(getMapper().fromRequest(userRequestDTO));
        URI location = URI.create("/user/" + entity.getId());
        return Response.created(location).build();
    }

    @RolesAllowed("user")
    @Override
    public Response update(String id, UserRequestDTO request) throws DomainException, InvocationTargetException, IllegalAccessException {
        return super.update(id, request);
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
