//package br.com.fiap.aimpress.dto.Curriculo;
//
//import br.com.fiap.aimpress.Domain.DetalheCurriculo;
//
//public record DetalhesDetalheCurriculoDTO(Long id, String titulo, String descricao) {
//    public DetalhesDetalheCurriculoDTO(DetalheCurriculo detalheCurriculo) {
//        if (detalheCurriculo != null) {
//            this(detalheCurriculo.getId(), detalheCurriculo.getTitulo(), detalheCurriculo.getDescricao());
//        } else {
//            this(null, null, null);
//        }
//    }
//}