package br.com.fiap.aimpress.dto.Vaga;

public record CadastroVagaDTO(
        String titulo,
        String descricao,
        String requisitos,
        Long empresaId
) {}

