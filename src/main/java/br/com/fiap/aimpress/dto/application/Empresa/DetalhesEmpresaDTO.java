package br.com.fiap.aimpress.dto.application.Empresa;

import br.com.fiap.aimpress.model.application.Empresa;

public record DetalhesEmpresaDTO(Long id, String nome, String descricao) {
    public DetalhesEmpresaDTO(Empresa empresa) {
        this(empresa.getId(), empresa.getNome(), empresa.getDescricao());
    }
}
