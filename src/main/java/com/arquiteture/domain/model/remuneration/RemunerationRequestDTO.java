package com.arquiteture.domain.model.remuneration;

import com.arquiteture.domain.enums.TypeRemunerationProvider;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemunerationRequestDTO {

    @NotBlank(message = "validation.field.not-blank")
    @NotNull(message = "validation.field.not-null")
    @Size(message = "{validation.remuneration.provider.size.min}", min = 2, max = 50)
    private String provider;

    @NotNull(message = "{validation.field.not-null}")
    private Double value;

    @NotNull(message = "{validation.field.not-null}")
    private TypeRemunerationProvider typeRemunerationProvider;
}
