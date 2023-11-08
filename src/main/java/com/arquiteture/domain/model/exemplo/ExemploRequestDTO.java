package com.arquiteture.domain.model.exemplo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExemploRequestDTO {

    @NotBlank(message = "{validation.blank.nome}")
    private String nome;

    @NotBlank(message = "{validation.blank.descricao}")
    private String descricao;
}
