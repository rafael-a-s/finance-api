package com.arquiteture.domain.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MultivaluedMap;
import java.util.Objects;

public record AuthRequest(

        @JsonProperty("grant_type")
        @QueryParam("grant_type")
        GrantType grantType,
        String code,
        String username,
        String password,

        @JsonProperty("refresh_token")
        @QueryParam("refresh_token")
        String refreshToken,

        @JsonProperty("redirect_uri")
        @QueryParam("redirect_uri")
        String redirectUri) {

    public static AuthRequest formMultiValueMap(MultivaluedMap<String, String> params) {
        var grantType = GrantType.valueOf(Objects.requireNonNull(params.getFirst("grant_type")).toUpperCase());

        return new AuthRequest(grantType,
                params.getFirst("code"),
                params.getFirst("username"),
                params.getFirst("password"),
                params.getFirst("refresh_token"),
                params.getFirst("redirect_uri"));
    }

}
