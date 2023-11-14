package com.arquiteture.domain.service.remuneration;

import com.arquiteture.core.repository.BaseRepository;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.Remuneration;
import com.arquiteture.domain.repository.RemunerationRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RemunerationService extends BaseService<Remuneration> implements IRemunerationService {

    protected RemunerationService (final BaseRepository<Remuneration> repository){
        super(repository);
    }

    public RemunerationService(){}

    @Override
    public RemunerationRepository getRepository() {
        return (RemunerationRepository) super.getRepository();
    }
}
