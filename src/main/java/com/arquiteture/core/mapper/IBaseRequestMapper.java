package com.arquiteture.core.mapper;

import com.arquiteture.core.entity.BaseEntity;

/**
 *
 * @param <T> - Entity.
 * @param <R> - Request.
 */
public interface IBaseRequestMapper<T extends BaseEntity, R> {

    T fromRequest(R request);

    R toRequest(T entity);
}
