package com.arquiteture.domain.entity;

import com.arquiteture.core.entity.BaseEntity;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "monthly_contribution")
public class MonthlyContribution extends BaseEntity {

    @Id
    @Column(name = "monthly_contribution_id")
    private String id;

    @Column(name = "name_investiment")
    private String nameInvestiment;

    @Column(name = "monthly_contribution_value")
    private Double value;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
