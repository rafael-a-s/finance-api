package com.arquiteture.domain.service.auth;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.domain.entity.User;
import com.arquiteture.domain.model.auth.AuthLogout;
import com.arquiteture.domain.model.auth.AuthRequest;
import com.arquiteture.domain.model.auth.AuthUser;
import com.arquiteture.domain.repository.UserRepository;
import com.arquiteture.domain.service.hash.HashService;
import com.arquiteture.domain.service.jwt.JwtService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MultivaluedMap;
import org.apache.commons.lang3.StringUtils;

@ApplicationScoped
public class AuthService implements IAuthService {

    @Inject
    UserRepository repository;

    @Inject
    HashService hashService;

    @Inject
    JwtService jwtService;

    @Override
    public AuthUser token(AuthRequest request) throws DomainException, JsonProcessingException {
        if (StringUtils.isBlank(request.cpf()) || StringUtils.isBlank(request.password())) {
            throw new DomainException("");
        }

        final var user = authUsingPassword(request.cpf(), request.password());
        final var token = getAcessToken(user);

        return AuthUser.createFromJwtToken(user, token);
    }

    @Override
    public AuthLogout logout(MultivaluedMap<String, String> params) {
        return null;
    }

    private String getAcessToken(User user) throws DomainException {

        return jwtService.generateJwt(user);
    }

    private User authUsingPassword(final String cpf, final String password) throws DomainException {
        final var passworEncrypted = hashService.getHashPassword(password);

        var userOptional = repository.findByCpfAndPassword(cpf, passworEncrypted);
        var user = userOptional.orElseThrow(() -> new DomainException("validation.auth.login.invalid"));
        return user;
    }


}
