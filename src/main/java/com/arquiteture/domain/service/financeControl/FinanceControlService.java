package com.arquiteture.domain.service.financeControl;

import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.FinanceControl;
import com.arquiteture.domain.repository.FinanceControlRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FinanceControlService extends BaseService<FinanceControl> implements IFinanceControlService {

    protected FinanceControlService(final FinanceControlRepository repository) {
    }

    public FinanceControlService() {
    }

    @Override
    public FinanceControlRepository getRepository() {
        return (FinanceControlRepository) super.getRepository();
    }
}
