package com.arquiteture.domain.service.user;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.repository.BaseRepository;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.User;
import com.arquiteture.domain.repository.UserRepository;
import com.arquiteture.domain.service.hash.IHashService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Objects;


@ApplicationScoped
public class UserService extends BaseService<User> implements IUserService {

    @Inject
    IHashService hashService;

    protected UserService(BaseRepository<User> repository) {
        super(repository);
    }
    public UserService(){}

    @Override
    public User create(User entity) throws DomainException {
        validate(entity);

        var passwordHash = hashService.getHashPassword(entity.getPassword());
        entity.setPassword(passwordHash);

        this.getRepository().persist(entity);
        return entity;
    }

    @Override
    public void validate(User entity) throws DomainException {
        super.validate(entity);
        validUsernameUnique(entity.getUsename());
    }

    private void validUsernameUnique(String username) throws DomainException {
        var optionalUser = this.getRepository().findByUsername(username);

        if(optionalUser.isPresent()){
            throw new DomainException("validation.user.username-exist");
        }
    }

    @Override
    public UserRepository getRepository() {
        return (UserRepository) super.getRepository();
    }
}
