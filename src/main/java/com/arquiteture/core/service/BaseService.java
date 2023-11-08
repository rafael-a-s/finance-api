package com.arquiteture.core.service;

import com.arquiteture.core.entity.BaseEntity;
import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.repository.BaseRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Transactional
public abstract class BaseService<T extends BaseEntity> implements IBaseService<T> {

    @Inject
    BaseRepository<T> repository;

    protected BaseService(){}

    protected BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public <U> List<U> listAll(Function<T, ? extends U> converter) {
        return repository.listAll().stream().map(converter).collect(Collectors.toList());
    }

    @Override
    public <U> T findById(String id, Function<T, ? extends U> converter) {
        return repository.findById(id);
    }

    @Override
    public void validate(T entity) throws DomainException {
        if(Objects.isNull(entity)){
            throw new DomainException("Entity is null.");
        }
    }

    @Override
    @Transactional
    public T create(T entity) throws DomainException{
        validate(entity);
        repository.persist(entity);

        return entity;
    }

    @Override
    @Transactional
    public <U> U create(T entity, Function<T, ? extends U> converter) throws DomainException {
        return converter.apply(this.create(entity));
    }

    @Override
    public void bind(T entity, T entityUpdate) {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setPropertyCondition(new Condition<Object, Object>() {
            @Override
            public boolean applies(MappingContext<Object, Object> context) {
                return context.getSource() != null;
            }
        });
        modelMapper.map(entityUpdate, entity);
    }

    @Override
    @Transactional
    public T update(String id, T entityUpdate) throws DomainException {
        final T t = repository.findByIdOptional(id).orElseThrow(() -> new DomainException("Error, id not exist."));

        validate(entityUpdate);
        bind(t, entityUpdate);
        repository.persist(t);

        return t;
    }

    @Override
    @Transactional
    public <U> U update(String id, T entityUpdate, Function<T, ? extends U> converter) throws DomainException, InvocationTargetException, IllegalAccessException {
        return converter.apply(this.update(id, entityUpdate));
    }

    @Override
    public void validDelete(T entity) throws DomainException {

    }

    @Override
    @Transactional
    public void delete(String id) throws DomainException {
        final T t = repository.findByIdOptional(id).orElseThrow(() -> new DomainException("Error, id not exist."));
        validate(t);

        repository.delete(t);
    }

    public BaseRepository<T> getRepository() {
        return this.repository;
    }
}
