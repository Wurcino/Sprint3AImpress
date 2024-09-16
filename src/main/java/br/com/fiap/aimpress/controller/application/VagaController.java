package br.com.fiap.aimpress.controller.application;

import br.com.fiap.aimpress.model.application.Vaga;
import br.com.fiap.aimpress.dto.application.Vaga.AtualizarVagaDTO;
import br.com.fiap.aimpress.dto.application.Vaga.CadastroVagaDTO;
import br.com.fiap.aimpress.dto.application.Vaga.DetalhesVagaDTO;
import br.com.fiap.aimpress.repository.application.VagaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vagas")
@Tag(name = "Vaga", description = "Operações relacionadas às vagas")
public class VagaController {

    private final VagaRepository vagaRepository;

    @Autowired
    public VagaController(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    @Operation(summary = "Detalhar uma vaga por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vaga encontrada"),
            @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesVagaDTO> detalhar(@PathVariable Long id) {
        var vaga = vagaRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(new DetalhesVagaDTO(vaga));
    }

    @Operation(summary = "Cadastrar nova vaga")
    @PostMapping
    public ResponseEntity<DetalhesVagaDTO> cadastrarVaga(@RequestBody CadastroVagaDTO dto) {
        Vaga novaVaga = new Vaga(dto);
        Vaga savedVaga = vagaRepository.save(novaVaga);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DetalhesVagaDTO(savedVaga));
    }

    @Operation(summary = "Atualizar uma vaga por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vaga atualizada"),
            @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<DetalhesVagaDTO> atualizarVaga(@PathVariable Long id, @RequestBody AtualizarVagaDTO dto) {
        Vaga vaga = vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        vaga.atualizar(dto);
        Vaga updatedVaga = vagaRepository.save(vaga);
        return ResponseEntity.ok(new DetalhesVagaDTO(updatedVaga));
    }

    @Operation(summary = "Excluir uma vaga por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Vaga excluída"),
            @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVaga(@PathVariable Long id) {
        Vaga vaga = vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        vagaRepository.delete(vaga);
        return ResponseEntity.noContent().build();
    }
}
