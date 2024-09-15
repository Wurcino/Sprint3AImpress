package br.com.fiap.aimpress.dto.application.Curriculo;

import br.com.fiap.aimpress.model.enums.Carreira;
import br.com.fiap.aimpress.model.enums.NivelEscolaridade;

public record AtualizarCurriculoDTO(
        String nome,
        String numeroTelefone,
        String resumo,
        String experiencia,
        NivelEscolaridade nivelEscolaridade,
        Carreira carreira,
        String cursos,
        String idiomas
) {}
