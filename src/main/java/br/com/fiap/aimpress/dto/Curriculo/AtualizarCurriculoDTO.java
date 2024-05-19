package br.com.fiap.aimpress.dto.Curriculo;

public record AtualizarCurriculoDTO(
        String nome,
        String numeroTelefone,
        AtualizarDetalheCurriculoDTO detalheCurriculo
) {}
