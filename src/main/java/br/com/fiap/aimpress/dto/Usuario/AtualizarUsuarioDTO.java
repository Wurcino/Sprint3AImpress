package br.com.fiap.aimpress.dto.Usuario;

import br.com.fiap.aimpress.dto.Curriculo.AtualizarCurriculoDTO;

import java.time.LocalDate;
import java.util.List;

public record AtualizarUsuarioDTO(
        String name,
        String email,
        LocalDate dataNascimento
) {}
