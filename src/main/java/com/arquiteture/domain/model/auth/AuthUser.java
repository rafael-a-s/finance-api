package com.arquiteture.domain.model.auth;

import com.arquiteture.domain.entity.User;
import com.arquiteture.domain.enums.Roles;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AuthUser{

    private String id;
    private String name;
    private String cpf;
    private String acessToken;
    private List<String> roles;

    public static AuthUser createFromJwtToken(User user, String token) throws JsonProcessingException {
        final var authUser = new AuthUser();

        authUser.setId(user.getId());
        authUser.setName(user.getFirstName());
        authUser.setCpf(user.getCpf());
        authUser.setAcessToken(token);
        authUser.setRoles(
                user.getRoles()
                        .stream()
                        .map(Roles::getLabel)
                        .collect(
                                Collectors.toList()
                        )
        );


        return authUser;
    }

}
