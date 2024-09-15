package br.com.fiap.aimpress.repository;

import br.com.fiap.aimpress.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
