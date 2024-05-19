package br.com.fiap.aimpress.dto.Vaga;

import br.com.fiap.aimpress.Domain.Vaga;
import br.com.fiap.aimpress.dto.Empresa.DetalhesEmpresaDTO;

public record DetalhesVagaDTO(Long id, String titulo, String descricao, String requisitos, DetalhesEmpresaDTO empresa) {
    public DetalhesVagaDTO(Vaga vaga) {
        this(vaga.getId(), vaga.getTitulo(), vaga.getDescricao(), vaga.getRequisitos(), new DetalhesEmpresaDTO(vaga.getEmpresa()));
    }
}
