package com.arquiteture.domain.model.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;
import org.jose4j.jwt.consumer.InvalidJwtException;
import java.util.List;

@Getter
@Setter
public class AuthUser extends AuthToken {

    private String id;
    private String name;
    private String email;
    private List<String> roles;

    public static AuthUser createFromJwtToken(AuthToken authToken) throws JsonProcessingException {
        final var user = new AuthUser();
        var claims = JwtClaims.getClaims(authToken.getAcessToken());

        user.setId(claims.getSub());
        user.setName(claims.getName());
        user.setEmail(claims.getEmail());
        user.setAcessToken(authToken.getAcessToken());
        user.setRefreshToken(authToken.getRefreshToken());
        user.setExpireIn(authToken.getExpireIn());
        user.setJti(authToken.getJti());
        user.setScope(authToken.getScope());
        user.setTokenType(authToken.getTokenType());

        return user;
    }

}
