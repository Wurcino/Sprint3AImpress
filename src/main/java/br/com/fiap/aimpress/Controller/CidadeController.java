//package br.com.fiap.aimpress.Controller;
//
//import br.com.fiap.aimpress.Domain.Cidade;
//import br.com.fiap.aimpress.dto.Cidade.AtualizarCidadeDTO;
//import br.com.fiap.aimpress.dto.Cidade.CadastroCidadeDTO;
//import br.com.fiap.aimpress.dto.Cidade.DetalhesCidadeDTO;
//import br.com.fiap.aimpress.repository.CidadeRepository;
//import jakarta.transaction.Transactional;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@RestController
//@RequestMapping("/cidades")
//public class CidadeController {
//
//    @Autowired
//    private CidadeRepository cidadeRepository;
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity<DetalhesCidadeDTO> cadastrar(@RequestBody @Valid CadastroCidadeDTO dto, UriComponentsBuilder builder) {
//        var cidade = new Cidade(dto);
//        cidade = cidadeRepository.save(cidade);
//        var uri = builder.path("/cidades/{id}").buildAndExpand(cidade.getId()).toUri();
//        return ResponseEntity.created(uri).body(new DetalhesCidadeDTO(cidade));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<DetalhesCidadeDTO> detalhar(@PathVariable Long id) {
//        var cidade = cidadeRepository.findById(id).orElseThrow();
//        return ResponseEntity.ok(new DetalhesCidadeDTO(cidade));
//    }
//
//    @PutMapping("/{id}")
//    @Transactional
//    public ResponseEntity<DetalhesCidadeDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarCidadeDTO dto) {
//        var cidade = cidadeRepository.findById(id).orElseThrow();
//        cidade.setNome(dto.nome());
//        cidade.setUf(dto.uf());
//        cidade.setDdd(dto.ddd());
//        return ResponseEntity.ok(new DetalhesCidadeDTO(cidade));
//    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity<Void> deletar(@PathVariable Long id) {
//        var cidade = cidadeRepository.findById(id).orElseThrow();
//        cidadeRepository.delete(cidade);
//        return ResponseEntity.noContent().build();
//    }
//}
