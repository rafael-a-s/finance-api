package com.arquiteture.domain.entity;

import com.arquiteture.core.entity.BaseEntity;

import com.arquiteture.domain.enums.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @Column(name = "id_user", nullable = false, length = 36)
    private String id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "cpf", length = 14)
    private String cpf;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = Roles.class)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"))
    @Column(name = "roles")
    @Enumerated(EnumType.ORDINAL)
    private Set<Roles> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FinanceControl financeControl;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
