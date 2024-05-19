package br.com.fiap.aimpress.dto.Curriculo;

import br.com.fiap.aimpress.Domain.DetalheCurriculo;
import br.com.fiap.aimpress.Domain.enums.Carreira;
import br.com.fiap.aimpress.Domain.enums.NivelEscolaridade;

public record DetalhesDetalheCurriculoDTO(Long id, String resumo, String experiencia, NivelEscolaridade nivelEscolaridade, Carreira carreira, String cursos, String idiomas) {
    public DetalhesDetalheCurriculoDTO(DetalheCurriculo detalheCurriculo) {
        this(detalheCurriculo.getId(), detalheCurriculo.getResumo(), detalheCurriculo.getExperiencia(), detalheCurriculo.getNivelEscolaridade(), detalheCurriculo.getCarreira(), detalheCurriculo.getCursos(), detalheCurriculo.getIdiomas());
    }
}