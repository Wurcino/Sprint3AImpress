package br.com.fiap.aimpress.repository.application;

import br.com.fiap.aimpress.model.application.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
