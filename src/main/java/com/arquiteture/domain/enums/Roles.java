package com.arquiteture.domain.enums;

public enum Roles {
    ADMIN(1, "admin"),
    USER(2, "user");

    private Integer id;
    private String label;

    Roles(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
