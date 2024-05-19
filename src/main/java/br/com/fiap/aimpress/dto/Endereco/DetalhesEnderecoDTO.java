package br.com.fiap.aimpress.dto.Endereco;

import br.com.fiap.aimpress.Domain.Endereco;
import br.com.fiap.aimpress.dto.Cidade.DetalhesCidadeDTO;

public record DetalhesEnderecoDTO(Long id, String logradouro, String cep, DetalhesCidadeDTO cidade) {
    public DetalhesEnderecoDTO(Endereco endereco) {
        this(endereco.getId(), endereco.getLogradouro(), endereco.getCep(), new DetalhesCidadeDTO(endereco.getCidade()));
    }
}
