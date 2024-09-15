package br.com.fiap.aimpress.dto.application.Curriculo;

import br.com.fiap.aimpress.model.application.Curriculo;
import br.com.fiap.aimpress.model.enums.Carreira;
import br.com.fiap.aimpress.model.enums.NivelEscolaridade;

public record DetalhesCurriculoDTO(Long id,
                                   String nome,
                                   String numeroTelefone,
                                   String resumo,
                                   String experiencia,
                                   NivelEscolaridade nivelEscolaridade,
                                   Carreira carreira,
                                   String cursos,
                                   String idiomas) {
    public DetalhesCurriculoDTO(Curriculo curriculo) {
        this(curriculo.getId(),
                curriculo.getNome(),
                curriculo.getNumeroTelefone(),
                curriculo.getResumo(),
                curriculo.getExperiencia(),
                curriculo.getNivelEscolaridade(),
                curriculo.getCarreira(),
                curriculo.getCursos(),
                curriculo.getIdiomas());
    }
}
