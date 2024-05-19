package br.com.fiap.aimpress.dto.Usuario;

import br.com.fiap.aimpress.Domain.Usuario;
import br.com.fiap.aimpress.dto.Curriculo.DetalhesCurriculoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record DetalhesUsuarioDTO(Long id, String name, String email, LocalDate dataNascimento, List<DetalhesCurriculoDTO> curriculos) {
    public DetalhesUsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getName(), usuario.getEmail(), usuario.getDataNascimento(), usuario.getCurriculos().stream().map(DetalhesCurriculoDTO::new).collect(Collectors.toList()));
    }
}
