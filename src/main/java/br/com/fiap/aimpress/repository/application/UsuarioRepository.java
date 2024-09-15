package br.com.fiap.aimpress.repository.application;

import br.com.fiap.aimpress.model.application.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
