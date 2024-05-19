package br.com.fiap.aimpress.dto.Endereco;

public record AtualizarEnderecoDTO(
        String logradouro,
        String cep,
        Long cidadeId
) {}
