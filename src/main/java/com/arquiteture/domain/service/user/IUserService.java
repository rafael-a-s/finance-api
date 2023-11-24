package com.arquiteture.domain.service.user;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.service.IBaseService;
import com.arquiteture.domain.entity.User;

public interface IUserService extends IBaseService<User> {
    void activeInative(String id) throws DomainException;
}
