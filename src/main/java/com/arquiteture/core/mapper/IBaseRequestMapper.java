package com.arquiteture.core.mapper;

import com.arquiteture.core.entity.BaseEntity;
import org.mapstruct.Mapping;

/**
 *
 * @param <T> - Entity.
 * @param <R> - Request.
 */
public interface IBaseRequestMapper<T extends BaseEntity, R> {

    T fromRequest(R request);

    R toRequest(T entity);
}
