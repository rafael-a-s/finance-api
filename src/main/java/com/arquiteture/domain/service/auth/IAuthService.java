package com.arquiteture.domain.service.auth;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.domain.model.auth.AuthLogout;
import com.arquiteture.domain.model.auth.AuthRequest;
import com.arquiteture.domain.model.auth.AuthUser;
import com.fasterxml.jackson.core.JsonProcessingException;import jakarta.ws.rs.core.MultivaluedMap;

public interface IAuthService {

    AuthUser token(AuthRequest authRequest) throws DomainException, JsonProcessingException;
    AuthLogout logout(MultivaluedMap<String, String> params);

}
