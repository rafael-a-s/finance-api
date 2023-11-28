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
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

@Path("/user")
@RolesAllowed({"user", "admin"})
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

    @PUT
    @Path("/v1/update-profile/{id}")
    @RolesAllowed({"user"})
    public Response updateProfile(@PathParam("id") String id, @Valid UserRequestDTO userRequestDTO) throws DomainException, InvocationTargetException, IllegalAccessException {

        var entityUpdatedReponse = this.getService().update(id, this.getMapper().fromRequest(userRequestDTO));
        return Response.ok(entityUpdatedReponse).build();
    }

    @PATCH
    @Path("/v1/active-inative/{id}")
    @RolesAllowed({"user"})
    public Response acticeInative(@PathParam("id") String id) throws DomainException {

        getService().activeInative(id);
        return Response.noContent().build();
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
