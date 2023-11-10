package com.arquiteture.domain.service.jwt;

import com.arquiteture.domain.entity.User;

public interface IJwtService {

    String generateJwt(User user);
}
