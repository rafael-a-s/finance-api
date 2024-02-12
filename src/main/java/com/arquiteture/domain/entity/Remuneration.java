package com.arquiteture.domain.entity;

import com.arquiteture.core.entity.BaseEntity;
import com.arquiteture.domain.enums.TypeRemunerationProvider;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "remuneration")
public class Remuneration extends BaseEntity {

    @Id
    @Column(name = "remuneration_id")
    private String id;

    @Column(name = "provider")
    private String provider;

    @Column(name = "value")
    private Double value;

    @Column(name = "type_provider")
    private TypeRemunerationProvider typeRemunerationProvider;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
