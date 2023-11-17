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

    @Column(name = "username")
    private String usename;

    @Column(name = "password")
    private String password;

    @ElementCollection
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"))
    @Column(name = "roles", length = 30)
    private Set<Roles> roles;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
