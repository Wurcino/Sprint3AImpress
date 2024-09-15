package br.com.fiap.aimpress.dto.Empresa;

import br.com.fiap.aimpress.model.Empresa;

public record DetalhesEmpresaDTO(Long id, String nome, String descricao) {
    public DetalhesEmpresaDTO(Empresa empresa) {
        this(empresa.getId(), empresa.getNome(), empresa.getDescricao());
    }
}
