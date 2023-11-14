package com.arquiteture.domain.model.remuneration;

import com.arquiteture.domain.enums.TypeRemunerationProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemunerationResponseDTO {

    private String id;
    private String provider;
    private BigDecimal value;
    private TypeRemunerationProvider typeRemunerationProvider;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private boolean active;
}
