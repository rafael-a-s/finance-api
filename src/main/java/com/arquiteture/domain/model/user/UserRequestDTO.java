package com.arquiteture.domain.model.user;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "{validation.field.not-blank}")
    @NotNull(message = "{validation.field.not-null}")
    @Size(message = "{validation.user.firstName.size}", max = 50, min = 3)
    private String firstName;

    @NotBlank(message = "{validation.field.not-blank}")
    @NotNull(message = "{validation.field.not-null}")
    @Size(message = "{validation.user.lastName.size}", max = 50, min = 3)
    private String lastName;

    @NotBlank(message = "{validation.field.not-blank}")
    @NotNull(message = "{validation.field.not-null}")
    @CPF(message = "{validation.user.cpf.format}")
    private String cpf;

    @NotBlank(message = "{validation.field.not-blank}")
    @NotNull(message = "{validation.field.not-null}")
    @Email(message = "{validation.user.email.format}")
    private String email;

    @NotBlank(message = "{validation.field.not-blank}")
    @NotNull(message = "{validation.field.not-null}")
    @Size(message = "{validation.user.password.size}", max = 16, min = 8)
    private String password;

}
