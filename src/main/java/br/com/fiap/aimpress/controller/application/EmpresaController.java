package br.com.fiap.aimpress.controller.application;

import br.com.fiap.aimpress.model.application.Empresa;
import br.com.fiap.aimpress.dto.application.Empresa.AtualizarEmpresaDTO;
import br.com.fiap.aimpress.dto.application.Empresa.CadastroEmpresaDTO;
import br.com.fiap.aimpress.dto.application.Empresa.DetalhesEmpresaDTO;
import br.com.fiap.aimpress.repository.application.EmpresaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresas")
@Tag(name = "Empresa", description = "Operações relacionadas às empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Operation(summary = "Cadastrar nova empresa")
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesEmpresaDTO> cadastrar(@RequestBody @Valid CadastroEmpresaDTO dto, UriComponentsBuilder builder) {
        Empresa empresa = new Empresa(dto);
        empresa = empresaRepository.save(empresa);
        URI uri = builder.path("/empresas/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEmpresaDTO(empresa));
    }

    @Operation(summary = "Detalhar uma empresa por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa encontrada"),
            @ApiResponse(responseCode = "404", description = "Empresa não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesEmpresaDTO> detalhar(@PathVariable Long id) {
        return empresaRepository.findById(id)
                .map(empresa -> ResponseEntity.ok(new DetalhesEmpresaDTO(empresa)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Listar todas as empresas")
    @GetMapping
    public ResponseEntity<List<DetalhesEmpresaDTO>> listar() {
        List<DetalhesEmpresaDTO> empresas = empresaRepository.findAll().stream()
                .map(DetalhesEmpresaDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(empresas);
    }

    @Operation(summary = "Atualizar uma empresa por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa atualizada"),
            @ApiResponse(responseCode = "404", description = "Empresa não encontrada")
    })
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesEmpresaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarEmpresaDTO dto) {
        return empresaRepository.findById(id)
                .map(empresa -> {
                    empresa.atualizar(dto);
                    return ResponseEntity.ok(new DetalhesEmpresaDTO(empresa));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar uma empresa por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Empresa deletada"),
            @ApiResponse(responseCode = "404", description = "Empresa não encontrada")
    })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return empresaRepository.findById(id)
                .map(empresa -> {
                    empresaRepository.delete(empresa);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
