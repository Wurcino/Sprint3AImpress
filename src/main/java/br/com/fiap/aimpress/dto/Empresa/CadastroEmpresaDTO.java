package br.com.fiap.aimpress.dto.Empresa;

import br.com.fiap.aimpress.dto.Endereco.CadastroEnderecoDTO;

public record CadastroEmpresaDTO(
        String nome,
        String descricao,
        CadastroEnderecoDTO endereco
) {}