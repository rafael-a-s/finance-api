package com.arquiteture.core.mapper;

import com.arquiteture.core.entity.BaseEntity;

/**
 * Classe base de mapeamento de entidades
 *
 * @param <T> - Entity.
 * @param <R> - Request.
 * @param <Q> - Response.
 */
public interface IBaseMapper<T extends BaseEntity, R, Q> extends IBaseRequestMapper<T, R>, IBaseResponseMapper<T, Q>  {
}
