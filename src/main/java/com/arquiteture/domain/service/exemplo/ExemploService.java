package com.arquiteture.domain.service.exemplo;

import com.arquiteture.core.repository.IBaseRepository;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.Exemplo;
import com.arquiteture.domain.repository.ExemploRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ExemploService extends BaseService<Exemplo> implements IExemploService {

    protected ExemploService(IBaseRepository<Exemplo> repository) {
        super(repository);
    }
    public ExemploService (){}

    @Override
    public ExemploRepository getRepository() {
        return (ExemploRepository) super.getRepository();
    }
}
