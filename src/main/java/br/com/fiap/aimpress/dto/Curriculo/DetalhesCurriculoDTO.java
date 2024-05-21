package br.com.fiap.aimpress.dto.Curriculo;

import br.com.fiap.aimpress.Domain.Curriculo;
import br.com.fiap.aimpress.Domain.enums.Carreira;
import br.com.fiap.aimpress.Domain.enums.NivelEscolaridade;

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
