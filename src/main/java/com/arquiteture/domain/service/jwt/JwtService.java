package com.arquiteture.domain.service.jwt;

import com.arquiteture.domain.entity.User;
import com.arquiteture.domain.enums.Roles;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class JwtService implements IJwtService {

     final Duration EXPIRATION_TIME = Duration.ofHours(24);

    @Override
    public String generateJwt(User user) {
        try {
            Instant now = Instant.now();

            Instant expiryDate = now.plus(EXPIRATION_TIME);

            Set<String> roles = user.getRoles()
                    .stream()
                    .map(Roles::getLabel)
                    .collect(Collectors.toSet());

            return Jwt.issuer("finance-jwt")
                    .subject(user.getId())
                    .groups(roles)
                    .expiresAt(expiryDate)
                    .sign();

        } catch (Exception e) {
            return null;
        }
    }
}
