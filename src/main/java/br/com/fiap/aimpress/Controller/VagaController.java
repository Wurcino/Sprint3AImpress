package br.com.fiap.aimpress.Controller;

import br.com.fiap.aimpress.Domain.Usuario;
import br.com.fiap.aimpress.Domain.Vaga;
import br.com.fiap.aimpress.dto.Usuario.CadastroUsuarioDTO;
import br.com.fiap.aimpress.dto.Usuario.DetalhesUsuarioDTO;
import br.com.fiap.aimpress.dto.Vaga.AtualizarVagaDTO;
import br.com.fiap.aimpress.dto.Vaga.CadastroVagaDTO;
import br.com.fiap.aimpress.dto.Vaga.DetalhesVagaDTO;
import br.com.fiap.aimpress.repository.VagaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private final VagaRepository vagaRepository;

    @Autowired
    public VagaController(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    @GetMapping("/{id}") // Endpoint para detalhar um usuário existente
    public ResponseEntity<DetalhesVagaDTO> detalhar(@PathVariable Long id) {
        var vaga = vagaRepository.findById(id).orElseThrow(); // Busca o usuário pelo ID fornecido
        return ResponseEntity.ok(new DetalhesVagaDTO(vaga)); // Retorna os detalhes do usuário encontrado
    }

    @PostMapping
    public ResponseEntity<DetalhesVagaDTO> cadastrarVaga(@RequestBody CadastroVagaDTO dto) {
        Vaga novaVaga = new Vaga(dto);
        Vaga savedVaga = vagaRepository.save(novaVaga);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DetalhesVagaDTO(savedVaga));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalhesVagaDTO> atualizarVaga(@PathVariable Long id, @RequestBody AtualizarVagaDTO dto) {
        Vaga vaga = vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        vaga.atualizar(dto);
        Vaga updatedVaga = vagaRepository.save(vaga);
        return ResponseEntity.ok(new DetalhesVagaDTO(updatedVaga));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVaga(@PathVariable Long id) {
        Vaga vaga = vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        vagaRepository.delete(vaga);
        return ResponseEntity.noContent().build();
    }
}