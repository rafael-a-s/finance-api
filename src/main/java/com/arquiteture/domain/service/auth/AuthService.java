package com.arquiteture.domain.service.auth;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.domain.model.auth.*;
import com.arquiteture.domain.service.auth.client.KeycloakClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;

@ApplicationScoped
public class AuthService implements IAuthService{

    private static final String CLIENT_SECRET = "client_secret";
    private static final String CLIENT_ID = "client_id";
    private static final String GRANT_TYPE = "grant_type";

    @RestClient
    KeycloakClient keycloakClient;


    @Override
    public AuthUser token(AuthRequest request) throws DomainException, JsonProcessingException {
        return getAcessToken(request);
    }

    private AuthUser getAcessToken(AuthRequest request) throws DomainException, JsonProcessingException {
        if(request.grantType().equals(GrantType.PASSWORD)){
            if(StringUtils.isBlank(request.username()) || StringUtils.isBlank(request.password())){
                throw new DomainException("");
            }

            return AuthUser.createFromJwtToken(authUsingPassword(request.username(), request.password()));
        }

        throw new DomainException("");
    }

    private AuthToken authUsingPassword(final String username, final String password) {
        MultivaluedMap<String, String> form = new MultivaluedHashMap<>();

        form.add(GRANT_TYPE, "password");
        form.add("username", username);
        form.add("password", password);

        return keycloakClient.authUsingPassword(form);
    }

    @Override
    public AuthLogout logout(MultivaluedMap<String, String> params) {
        var refresh_token = params.getFirst("refresh_token");

        MultivaluedMap<String, String> form = new MultivaluedHashMap<>();
        form.add("refresh_token", refresh_token);

        return keycloakClient.logout(form);
    }
}
