package com.arquiteture.domain.repository;

import com.arquiteture.core.repository.BaseRepository;
import com.arquiteture.domain.entity.Exemplo;
import com.arquiteture.domain.entity.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements BaseRepository<User> {
    public Optional<User> findByUsername(String usename){
        return find("username = ?1", usename).firstResultOptional();
    }
}
