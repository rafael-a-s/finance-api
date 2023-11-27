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
    @Min(value = 2, message = "validation.remuneration.provider.size.min")
    @Max(value = 50, message = "validation.remuneration.provider.size.max")
    private String provider;

    @NotBlank(message = "validation.field.not-blank")
    @NotNull(message = "validation.field.not-null")
    private Double value;

    @NotBlank(message = "validation.field.not-blank")
    @NotNull(message = "validation.field.not-null")
    private TypeRemunerationProvider typeRemunerationProvider;
}
