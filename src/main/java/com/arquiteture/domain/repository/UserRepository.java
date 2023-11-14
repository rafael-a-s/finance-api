package com.arquiteture.domain.repository;

import com.arquiteture.core.repository.IBaseRepository;
import com.arquiteture.domain.entity.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements IBaseRepository<User> {
    public Optional<User> findByUsername(String usename){
        return find("username = ?1", usename).firstResultOptional();
    }
}
