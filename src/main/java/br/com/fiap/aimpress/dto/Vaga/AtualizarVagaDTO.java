package br.com.fiap.aimpress.dto.Vaga;

public record AtualizarVagaDTO(
        String titulo,
        String descricao,
        String requisitos,
        Long empresaId
) {}
