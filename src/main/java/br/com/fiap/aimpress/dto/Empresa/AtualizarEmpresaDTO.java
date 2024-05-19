package br.com.fiap.aimpress.dto.Empresa;

import br.com.fiap.aimpress.dto.Endereco.AtualizarEnderecoDTO;

public record AtualizarEmpresaDTO(
        String nome,
        String descricao,
        AtualizarEnderecoDTO endereco
) {}
