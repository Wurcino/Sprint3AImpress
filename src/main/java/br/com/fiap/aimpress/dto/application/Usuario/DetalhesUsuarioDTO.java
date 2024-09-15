package br.com.fiap.aimpress.dto.application.Usuario;

import br.com.fiap.aimpress.model.application.Usuario;

import java.time.LocalDate;

public record DetalhesUsuarioDTO(Long id, String name, String email, LocalDate dataNascimento) {
    public DetalhesUsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getName(), usuario.getEmail(), usuario.getDataNascimento());
    }
}
