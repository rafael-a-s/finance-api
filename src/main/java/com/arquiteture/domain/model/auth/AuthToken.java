package com.arquiteture.domain.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthToken {

    @JsonProperty("access_token")
    private String acessToken;

    @JsonProperty("expires_in")
    private long expireIn;

    private String jti;

    @JsonProperty("refresh_token")
    private String refreshToken;

    private String scope;

    @JsonProperty("token_type")
    private String tokenType;

    public boolean isTokenExpired() {
        return System.currentTimeMillis() > this.expireIn;
    }

}
