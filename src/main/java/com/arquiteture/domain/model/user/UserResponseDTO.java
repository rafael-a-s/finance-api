package com.arquiteture.domain.model.user;

import com.arquiteture.domain.enums.Roles;
import com.arquiteture.domain.model.financeControl.FinanceControlResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String cpf;
    private String email;
    private Set<Roles> roles;
    private FinanceControlResponseDTO financeControl;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private boolean active;

}