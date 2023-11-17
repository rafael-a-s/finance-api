package com.arquiteture.domain.service.financeControl;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.service.IBaseService;
import com.arquiteture.domain.entity.FinanceControl;

public interface IFinanceControlService extends IBaseService<FinanceControl> {

    public FinanceControl initializeFinanceControlInDataBase() throws DomainException;
}
