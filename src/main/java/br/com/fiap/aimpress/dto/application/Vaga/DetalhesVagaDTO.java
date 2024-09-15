package br.com.fiap.aimpress.dto.application.Vaga;

import br.com.fiap.aimpress.dto.application.Empresa.DetalhesEmpresaDTO;
import br.com.fiap.aimpress.model.application.Vaga;

public record DetalhesVagaDTO(Long id, String titulo, String descricao, String requisitos, DetalhesEmpresaDTO empresa) {
    public DetalhesVagaDTO(Vaga vaga) {
        this(vaga.getId(), vaga.getTitulo(), vaga.getDescricao(), vaga.getRequisitos(), new DetalhesEmpresaDTO(vaga.getEmpresa()));
    }
}
