package com.arquiteture.domain.model.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "validation.blank.username")
    private String username;

    @NotBlank(message = "validation.blank.password")
    private String password;

}
