package com.arquiteture.core.resource;

import com.arquiteture.core.entity.BaseEntity;
import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.mapper.IBaseMapper;
import com.arquiteture.core.service.IBaseService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;

/**
 * Controller base contém métodos padrões de um crud
 *
 * @param <T> - Entity.
 * @param <R> - Request.
 * @param <Q> - Response.
 */
public abstract class BaseResource<T extends BaseEntity, R, Q> {

    private final IBaseService<T> service;

    private final IBaseMapper<T, R, Q> mapper;

    protected BaseResource(final IBaseService<T> service, final IBaseMapper<T, R, Q> mapper){
        this.service =service;
        this.mapper = mapper;
    }

    @Path("/all")
    @GET
    public Response findAll() {
        var response = service.listAll(mapper::toResponse);
        return Response.ok(response).build();
    }

    @Path("/{id}")
    @GET
    public Response findById(@PathParam("id") String id) throws DomainException {
        var response = service.findById(id, mapper::toResponse);
        return Response.ok(response).build();
    }

    @POST
    public Response create(@Valid R request) throws DomainException {
        var response = service.create(mapper.fromRequest(request), mapper::toResponse);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @Path("/{id}")
    @PUT
    public Response update(@PathParam("id") String id, @Valid R request) throws DomainException, InvocationTargetException, IllegalAccessException {
        var response = service.update(id, mapper.fromRequest(request), mapper::toResponse);
        return Response.ok(response).build();
    }

    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") String id) throws DomainException {
        service.delete(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    protected IBaseService<T> getService() {
        return service;
    }

    protected IBaseMapper<T, R, Q> getMapper(){
        return mapper;
    }

}
