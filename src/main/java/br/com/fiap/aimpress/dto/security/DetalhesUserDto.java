package br.com.fiap.aimpress.dto.security;

import br.com.fiap.aimpress.model.user.User;

public record DetalhesUserDto(
        Long id,
        String name,
        String email
) {
    public DetalhesUserDto(User user) {
        this(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}
