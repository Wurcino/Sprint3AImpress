package br.com.fiap.aimpress.dto.Usuario;

import br.com.fiap.aimpress.dto.Curriculo.CadastroCurriculoDTO;

import java.time.LocalDate;
import java.util.List;

public record CadastroUsuarioDTO(
        String name,
        String email,
        LocalDate dataNascimento,
        List<CadastroCurriculoDTO> curriculos
) {}
