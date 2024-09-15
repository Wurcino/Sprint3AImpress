package br.com.fiap.aimpress.dto.application.Usuario;

import java.time.LocalDate;

public record AtualizarUsuarioDTO(
        String name,
        String email,
        LocalDate dataNascimento
) {}
