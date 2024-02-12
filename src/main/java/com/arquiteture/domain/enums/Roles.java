package com.arquiteture.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Objects;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
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

    public static Roles valueOf(Integer id) throws IllegalArgumentException {
        if (Objects.isNull(id)) {
            return null;
        }
        for (Roles role : Roles.values()) {
            if(role.getId().equals(id)) {
                return role;
            }
        }

        throw new IllegalArgumentException("ID inválido:"+ id);
    }
}
