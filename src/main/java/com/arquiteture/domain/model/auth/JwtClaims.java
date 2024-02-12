package com.arquiteture.domain.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JwtClaims {

    private String sub;
    private String name;
    private String email;

    public static JwtClaims getClaims(String token) throws JsonProcessingException {
        var splitToken = token.split("\\.");

        return new ObjectMapper().readValue(new String(Base64.getDecoder().decode(splitToken[1]), StandardCharsets.UTF_8), JwtClaims.class);
    }

}
