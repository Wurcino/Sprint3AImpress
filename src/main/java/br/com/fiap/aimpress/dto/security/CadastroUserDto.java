package br.com.fiap.aimpress.dto.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroUserDto(

        @NotBlank(message = "Nome não pode ser vazio")
        @Size(max = 20, message = "Username deve conter no máximo 20 caracteres")
        String username,

        @NotBlank(message = "Email não pode ser vazio")
        @Size(max = 100, message = "Email deve conter no máximo 100 caracteres")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "Senha não pode ser vazia")
        @Size(max = 100, message = "Senha deve conter no máximo 100 caracteres")
        String password
) {
}
