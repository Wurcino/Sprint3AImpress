package br.com.fiap.aimpress.dto.security.autenticacao;

import jakarta.validation.constraints.NotBlank;

public record DadosLoginDto(

        @NotBlank
        String login,

        @NotBlank
        String password,

        @NotBlank
        String email
) {
}
