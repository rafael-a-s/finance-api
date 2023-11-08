package com.arquiteture.core.service;

import com.arquiteture.core.entity.BaseEntity;
import com.arquiteture.core.exception.DomainException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Function;

public interface IBaseService<T extends BaseEntity> {

    <U> List<U> listAll(Function<T, ? extends U> converter);

    <U> T findById(String id, Function<T, ? extends U> converter);

    void validate(T entity) throws DomainException;

    T create(T entity) throws DomainException;

    <U> U create(T entity, Function<T, ? extends U> converter) throws DomainException;

    void bind(T entity, T entityUpdate) throws InvocationTargetException, IllegalAccessException;

    T update(String id, T entityUpdate) throws DomainException, InvocationTargetException, IllegalAccessException;

    <U> U update(String id, T entityUpdate, Function<T, ? extends U> converter) throws DomainException, InvocationTargetException, IllegalAccessException;

    void validDelete(T entity) throws DomainException;

    void delete(String id) throws DomainException;
}
