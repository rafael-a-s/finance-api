package com.arquiteture.core.repository;

import com.arquiteture.core.entity.BaseEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public interface IBaseRepository<T extends BaseEntity> extends PanacheRepositoryBase<T, String> {
}
