package br.com.fiap.aimpress.repository.application;


import br.com.fiap.aimpress.model.application.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
}
