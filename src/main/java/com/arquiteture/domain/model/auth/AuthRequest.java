package com.arquiteture.domain.model.auth;

public record AuthRequest(
        String cpf,
        String password
        ) { }
