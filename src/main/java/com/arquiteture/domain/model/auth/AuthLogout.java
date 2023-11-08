package com.arquiteture.domain.model.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthLogout {

    private String redirectUrl;
    private boolean redirect;

}
