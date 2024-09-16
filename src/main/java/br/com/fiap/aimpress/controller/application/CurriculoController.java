package br.com.fiap.aimpress.controller.application;

import br.com.fiap.aimpress.model.application.Curriculo;
import br.com.fiap.aimpress.dto.application.Curriculo.AtualizarCurriculoDTO;
import br.com.fiap.aimpress.dto.application.Curriculo.CadastroCurriculoDTO;
import br.com.fiap.aimpress.dto.application.Curriculo.DetalhesCurriculoDTO;
import br.com.fiap.aimpress.repository.application.CurriculoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/curriculos")
@Tag(name = "Currículo", description = "Operações relacionadas aos currículos")
public class CurriculoController {

    private final CurriculoRepository curriculoRepository;

    public CurriculoController(CurriculoRepository curriculoRepository) {
        this.curriculoRepository = curriculoRepository;
    }

    @Operation(summary = "Buscar currículo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Currículo encontrado"),
            @ApiResponse(responseCode = "404", description = "Currículo não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesCurriculoDTO> buscarPorId(@PathVariable Long id) {
        Optional<Curriculo> curriculoOptional = curriculoRepository.findById(id);
        if (curriculoOptional.isPresent()) {
            DetalhesCurriculoDTO detalhesCurriculoDTO = new DetalhesCurriculoDTO(curriculoOptional.get());
            return ResponseEntity.ok(detalhesCurriculoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Listar todos os currículos")
    @GetMapping
    public ResponseEntity<List<DetalhesCurriculoDTO>> listarCurriculos() {
        List<Curriculo> curriculos = curriculoRepository.findAll();
        List<DetalhesCurriculoDTO> detalhesCurriculoDTOList = curriculos.stream()
                .map(DetalhesCurriculoDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(detalhesCurriculoDTOList);
    }

    @Operation(summary = "Cadastrar novo currículo")
    @PostMapping
    public ResponseEntity<DetalhesCurriculoDTO> cadastrarCurriculo(@RequestBody CadastroCurriculoDTO dto) {
        Curriculo curriculo = curriculoRepository.save(new Curriculo(dto));
        DetalhesCurriculoDTO detalhesCurriculoDTO = new DetalhesCurriculoDTO(curriculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalhesCurriculoDTO);
    }

    @Operation(summary = "Atualizar currículo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Currículo atualizado"),
            @ApiResponse(responseCode = "404", description = "Currículo não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<DetalhesCurriculoDTO> atualizarCurriculo(@PathVariable Long id, @RequestBody AtualizarCurriculoDTO dto) {
        Optional<Curriculo> curriculoOptional = curriculoRepository.findById(id);
        if (curriculoOptional.isPresent()) {
            Curriculo curriculo = curriculoOptional.get();
            curriculo.atualizar(dto);
            curriculo = curriculoRepository.save(curriculo);
            DetalhesCurriculoDTO detalhesCurriculoDTO = new DetalhesCurriculoDTO(curriculo);
            return ResponseEntity.ok(detalhesCurriculoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletar currículo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Currículo deletado"),
            @ApiResponse(responseCode = "404", description = "Currículo não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurriculo(@PathVariable Long id) {
        if (curriculoRepository.existsById(id)) {
            curriculoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
