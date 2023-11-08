package com.arquiteture.core.mapper;

import com.arquiteture.core.entity.BaseEntity;
import java.util.List;

/**
 *
 * @param <T> - Entity.
 * @param <Q> - Response.
 */
public interface IBaseResponseMapper<T extends BaseEntity, Q> {

    Q toResponse(T entity);

    List<Q> toListResponse(List<T> entityList);

}
