package br.com.fiap.aimpress.dto.application.Vaga;

public record AtualizarVagaDTO(
        String titulo,
        String descricao,
        String requisitos,
        Long empresaId
) {}
