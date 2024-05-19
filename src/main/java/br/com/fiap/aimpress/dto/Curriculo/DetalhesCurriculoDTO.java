package br.com.fiap.aimpress.dto.Curriculo;

import br.com.fiap.aimpress.Domain.Curriculo;

public record DetalhesCurriculoDTO(Long id, String nome, String numeroTelefone, DetalhesDetalheCurriculoDTO detalheCurriculo) {
    public DetalhesCurriculoDTO(Curriculo curriculo) {
        this(curriculo.getId(), curriculo.getNome(), curriculo.getNumeroTelefone(), new DetalhesDetalheCurriculoDTO(curriculo.getDetalheCurriculo()));
    }
}
