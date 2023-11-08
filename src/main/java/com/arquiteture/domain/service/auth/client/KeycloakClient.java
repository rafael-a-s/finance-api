package com.arquiteture.domain.service.auth.client;

import com.arquiteture.domain.model.auth.AuthLogout;
import com.arquiteture.domain.model.auth.AuthToken;
import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.hibernate.annotations.Comment;

import java.util.Base64;

@Path("/openid-connect")
@ClientHeaderParam(name = "Authorization", value = "{authBasic}")
@RegisterRestClient(configKey = "keycloak-api")
public interface KeycloakClient {

    @POST
    @Path("/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    AuthToken authUsingPassword(MultivaluedMap<String, String> form);

    @POST
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    AuthLogout logout(MultivaluedMap<String, String> params);

    @ClientExceptionMapper
    static RuntimeException toException(Response response) {
        if (response.getStatus() == 500) {
            return new RuntimeException("The remote service responded with HTTP 500");
        }

        return null;
    }

    default String authBasic() {
        return "Basic " +
                Base64.getEncoder().encodeToString("backend-service:secret".getBytes());
    }

}
