package com.arquiteture.domain.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MultivaluedMap;
import java.util.Objects;

public record AuthRequest(
        String cpf,
        String password
        ) { }
