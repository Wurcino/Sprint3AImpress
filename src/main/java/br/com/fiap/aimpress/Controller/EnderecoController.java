//package br.com.fiap.aimpress.Controller;
//
//import br.com.fiap.aimpress.Domain.Endereco;
//import br.com.fiap.aimpress.Domain.Cidade;
//import br.com.fiap.aimpress.dto.Endereco.AtualizarEnderecoDTO;
//import br.com.fiap.aimpress.dto.Endereco.CadastroEnderecoDTO;
//import br.com.fiap.aimpress.dto.Endereco.DetalhesEnderecoDTO;
//import br.com.fiap.aimpress.repository.CidadeRepository;
//import br.com.fiap.aimpress.repository.EnderecoRepository;
//import jakarta.persistence.EntityNotFoundException;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.net.URI;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/enderecos")
//public class EnderecoController {
//
//    @Autowired
//    private EnderecoRepository enderecoRepository;
//
//    @Autowired
//    private CidadeRepository cidadeRepository;
//
//    @PostMapping // Endpoint para cadastrar um novo endereço
//    @Transactional
//    public ResponseEntity<DetalhesEnderecoDTO> cadastrar(@RequestBody @Valid CadastroEnderecoDTO dto, UriComponentsBuilder builder) {
//        Endereco endereco = new Endereco(dto);
//
//        Optional<Cidade> optionalCidade = cidadeRepository.findById(dto.getCidadeId());
//
//        if (optionalCidade.isPresent()) {
//            endereco.setCidade(optionalCidade.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//        endereco = enderecoRepository.save(endereco);
//        URI uri = builder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
//        return ResponseEntity.created(uri).body(new DetalhesEnderecoDTO(endereco));
//    }
//
//    @GetMapping("/{id}") // Endpoint para detalhar um endereço existente
//    public ResponseEntity<DetalhesEnderecoDTO> detalhar(@PathVariable Long id) {
//        Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);
//
//        if (optionalEndereco.isPresent()) {
//            return ResponseEntity.ok(new DetalhesEnderecoDTO(optionalEndereco.get()));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("/{id}") // Endpoint para atualizar um endereço existente
//    @Transactional
//    public ResponseEntity<DetalhesEnderecoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarEnderecoDTO dto) {
//        Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);
//
//        if (optionalEndereco.isPresent()) {
//            Endereco endereco = optionalEndereco.get();
//            endereco.atualizar(dto);
//            return ResponseEntity.ok(new DetalhesEnderecoDTO(endereco));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}") // Endpoint para deletar um endereço existente
//    @Transactional
//    public ResponseEntity<Void> deletar(@PathVariable Long id) {
//        Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);
//
//        if (optionalEndereco.isPresent()) {
//            enderecoRepository.delete(optionalEndereco.get());
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}