package com.arquiteture.resource.auth;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.domain.model.auth.AuthLogout;
import com.arquiteture.domain.model.auth.AuthRequest;
import com.arquiteture.domain.model.auth.AuthToken;
import com.arquiteture.domain.service.auth.AuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import org.jboss.resteasy.reactive.RestForm;

@Path("/auth")
public class AuthResource {

    @Inject
    AuthService service;

    @POST
    @Path("/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public AuthToken token(MultivaluedMap<String, String> params) throws DomainException, JsonProcessingException {
        return service.token(AuthRequest.formMultiValueMap(params));
    }

    @POST
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public AuthLogout logout(MultivaluedMap<String, String> params) {
        return service.logout(params);
    }
}
