package com.arquiteture.domain.service.financeControl;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.service.IBaseService;
import com.arquiteture.domain.entity.FinanceControl;
import com.arquiteture.domain.entity.MonthlyContribution;
import com.arquiteture.domain.entity.Remuneration;
import com.arquiteture.domain.entity.TypeExpense;

import java.util.List;

public interface IFinanceControlService extends IBaseService<FinanceControl> {

    FinanceControl initializeFinanceControlInDataBase() throws DomainException;

    void addTypeExpense(TypeExpense typeExpense) throws DomainException;

    void addRemuneration(Remuneration remuneration) throws DomainException;

    void addMonthlyContribution(MonthlyContribution monthlyContribution) throws DomainException;

    List<MonthlyContribution> getAllMonthlyContibutionOfUserUsingSubject() throws DomainException;

    void deleteMonthlyContribution(String id) throws DomainException;

    void deleteTypeExpense(String id) throws DomainException;

    void deleteRemuneration(String id) throws DomainException;
}