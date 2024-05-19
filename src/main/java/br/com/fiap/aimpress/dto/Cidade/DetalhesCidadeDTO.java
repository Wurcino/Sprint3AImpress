package br.com.fiap.aimpress.dto.Cidade;

import br.com.fiap.aimpress.Domain.Cidade;

public record DetalhesCidadeDTO(Long id, String nome, String uf, Integer ddd) {
    public DetalhesCidadeDTO(Cidade cidade) {
        this(cidade.getId(), cidade.getNome(), cidade.getUf(), cidade.getDdd());
    }
}
