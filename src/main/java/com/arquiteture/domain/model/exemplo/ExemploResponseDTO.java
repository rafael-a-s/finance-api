package com.arquiteture.domain.model.exemplo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExemploResponseDTO {

    private String id;
    private String nome;
    private String descricao;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private boolean active;

}
