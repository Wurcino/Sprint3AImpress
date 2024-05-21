package br.com.fiap.aimpress.Controller;

import br.com.fiap.aimpress.Domain.Empresa;
import br.com.fiap.aimpress.dto.Empresa.AtualizarEmpresaDTO;
import br.com.fiap.aimpress.dto.Empresa.CadastroEmpresaDTO;
import br.com.fiap.aimpress.dto.Empresa.DetalhesEmpresaDTO;
import br.com.fiap.aimpress.repository.EmpresaRepository;
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
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping // Endpoint para cadastrar uma nova empresa
    @Transactional
    public ResponseEntity<DetalhesEmpresaDTO> cadastrar(@RequestBody @Valid CadastroEmpresaDTO dto, UriComponentsBuilder builder) {
        Empresa empresa = new Empresa(dto);
        empresa = empresaRepository.save(empresa);
        URI uri = builder.path("/empresas/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEmpresaDTO(empresa));
    }

    @GetMapping("/{id}") // Endpoint para detalhar uma empresa existente
    public ResponseEntity<DetalhesEmpresaDTO> detalhar(@PathVariable Long id) {
        return empresaRepository.findById(id)
                .map(empresa -> ResponseEntity.ok(new DetalhesEmpresaDTO(empresa)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping // Endpoint para listar todas as empresas
    public ResponseEntity<List<DetalhesEmpresaDTO>> listar() {
        List<DetalhesEmpresaDTO> empresas = empresaRepository.findAll().stream()
                .map(DetalhesEmpresaDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(empresas);
    }

    @PutMapping("/{id}") // Endpoint para atualizar uma empresa existente
    @Transactional
    public ResponseEntity<DetalhesEmpresaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarEmpresaDTO dto) {
        return empresaRepository.findById(id)
                .map(empresa -> {
                    empresa.atualizar(dto);
                    return ResponseEntity.ok(new DetalhesEmpresaDTO(empresa));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") // Endpoint para deletar uma empresa existente
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
