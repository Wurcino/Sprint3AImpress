package br.com.fiap.aimpress.dto.Curriculo;

public record CadastroCurriculoDTO(
        String nome,
        String numeroTelefone,
        CadastroDetalheCurriculoDTO detalheCurriculo
) {}
