package com.arquiteture.domain.converter;

import com.arquiteture.domain.enums.Roles;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Roles, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Roles attribute) {
        return null;
    }

    @Override
    public Roles convertToEntityAttribute(Integer dbData) {
        return null;
    }
}
