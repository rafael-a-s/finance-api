package com.arquiteture.domain.enums;

public enum TypeRemunerationProvider {
    INTERNSHIP(1, "Estágio"),
    FREELANCER(2, "Freelancer"),
    CONTRACT(3, "Contrato"),
    CLT(4, "CLT"),
    OTHER(5, "Outro");

    private Integer id;
    private String label;

    TypeRemunerationProvider(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
