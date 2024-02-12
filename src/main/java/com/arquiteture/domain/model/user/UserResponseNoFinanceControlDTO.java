package com.arquiteture.domain.model.user;

import java.time.LocalDateTime;
import java.util.Set;

import com.arquiteture.domain.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseNoFinanceControlDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String cpf;
    private String email;
    private Set<Roles> roles;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private boolean active;
}
