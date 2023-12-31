package com.arquiteture.domain.service.financeControl;

import com.arquiteture.core.exception.DomainException;
import com.arquiteture.core.service.BaseService;
import com.arquiteture.domain.entity.Expense;
import com.arquiteture.domain.entity.FinanceControl;
import com.arquiteture.domain.entity.MonthlyContribution;
import com.arquiteture.domain.entity.Remuneration;
import com.arquiteture.domain.repository.FinanceControlRepository;
import com.arquiteture.domain.service.user.IUserService;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.resource.spi.work.SecurityContext;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.ArrayList;
import java.util.Objects;

@ApplicationScoped
public class FinanceControlService extends BaseService<FinanceControl> implements IFinanceControlService {

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    IUserService userService;

    protected FinanceControlService(final FinanceControlRepository repository) {
        super(repository);
    }

    public FinanceControlService() {
    }

    @Override
    public FinanceControl initializeFinanceControlInDataBase() throws DomainException {

        var userForFinanceControl = userService.findById(jsonWebToken.getSubject());

        FinanceControl entity = new FinanceControl();
        entity.setUser(userForFinanceControl);

        validate(entity);
        getRepository().persist(entity);

        if (Objects.isNull(entity.getId())) {
            throw new DomainException("Ocorreu um erro.");
        }

        return entity;
    }

    @Override
    public void validate(FinanceControl entity) throws DomainException {
        super.validate(entity);

        var entityOptional = getRepository().findAll().firstResultOptional();
        if (entityOptional.isPresent()) {
            throw new DomainException("There is already a finance control!");
        }
    }

    private FinanceControl findUniqueFinanceControl() throws DomainException {
        String idUser = jsonWebToken.getSubject();
        return getRepository().findFinanceControlForUser(idUser).orElseThrow(() -> new DomainException("ID user ivalid, financeControl not found."));
    }

    @Override
    public void addExpense(Expense expense) throws DomainException {
        var entity = findUniqueFinanceControl();
        if (Objects.isNull(entity.getExpensesFixes())) {
            entity.setExpensesFixes(new ArrayList<>());
        }

        entity.getExpensesFixes().add(expense);

        getRepository().persist(entity);
    }

    @Override
    public void addRemuneration(Remuneration remuneration) throws DomainException {
        var entity = findUniqueFinanceControl();
        if (Objects.isNull(entity.getRemunerations())) {
            entity.setRemunerations(new ArrayList<>());
        }

        entity.getRemunerations().add(remuneration);

        getRepository().persist(entity);
    }

    @Override
    public void addMonthlyContribution(MonthlyContribution monthlyContribution) throws DomainException {
        var entity = findUniqueFinanceControl();
        if (Objects.isNull(entity.getMonthlyContributions())) {
            entity.setMonthlyContributions(new ArrayList<>());
        }

        entity.getMonthlyContributions().add(monthlyContribution);

        getRepository().persist(entity);
    }

    @Override
    public FinanceControlRepository getRepository() {
        return (FinanceControlRepository) super.getRepository();
    }
}
