package br.com.fiap.aimpress.dto.Curriculo;

import br.com.fiap.aimpress.Domain.enums.Carreira;
import br.com.fiap.aimpress.Domain.enums.NivelEscolaridade;

public record AtualizarDetalheCurriculoDTO(
        String resumo,
        String experiencia,
        NivelEscolaridade nivelEscolaridade,
        Carreira carreira,
        String cursos,
        String idiomas
) {}
