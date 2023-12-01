package com.arquiteture.domain.repository;

import com.arquiteture.core.repository.IBaseRepository;
import com.arquiteture.domain.entity.FinanceControl;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class FinanceControlRepository implements IBaseRepository<FinanceControl> {

    public Optional<FinanceControl> findFinanceControlForUser(String idUser) {
        return find("id_user = ?1", idUser).firstResultOptional();
    }
}
