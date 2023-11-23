package com.arquiteture.resource.auth;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.domain.model.auth.AuthLogout;
import com.arquiteture.domain.model.auth.AuthRequest;
import com.arquiteture.domain.model.auth.AuthToken;
import com.arquiteture.domain.model.auth.AuthUser;
import com.arquiteture.domain.service.auth.AuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;

@Path("/auth")
public class AuthResource {

    @Inject
    AuthService service;

    @POST
    @Path("/token")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public AuthUser token(AuthRequest request) throws DomainException, JsonProcessingException {
        return service.token(request);
    }

    @POST
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public AuthLogout logout(MultivaluedMap<String, String> params) {
        return service.logout(params);
    }
}
