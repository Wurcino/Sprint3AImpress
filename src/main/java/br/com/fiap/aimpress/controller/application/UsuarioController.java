package br.com.fiap.aimpress.controller.application;

import br.com.fiap.aimpress.model.application.Usuario;
import br.com.fiap.aimpress.dto.application.Usuario.AtualizarUsuarioDTO;
import br.com.fiap.aimpress.dto.application.Usuario.CadastroUsuarioDTO;
import br.com.fiap.aimpress.dto.application.Usuario.DetalhesUsuarioDTO;
import br.com.fiap.aimpress.repository.application.UsuarioRepository;
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

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuário", description = "Operações relacionadas aos usuários")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Operation(summary = "Cadastrar novo usuário")
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesUsuarioDTO> cadastrar(@RequestBody @Valid CadastroUsuarioDTO dto, UriComponentsBuilder builder) {
        var usuario = new Usuario(dto);
        usuario = usuarioRepository.save(usuario);
        var uri = builder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesUsuarioDTO(usuario));
    }

    @Operation(summary = "Detalhar um usuário por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesUsuarioDTO> detalhar(@PathVariable Long id) {
        var usuario = usuarioRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(new DetalhesUsuarioDTO(usuario));
    }

    @Operation(summary = "Atualizar um usuário por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesUsuarioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarUsuarioDTO dto) {
        var usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.atualizar(dto);
        return ResponseEntity.ok(new DetalhesUsuarioDTO(usuario));
    }

    @Operation(summary = "Deletar um usuário por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário deletado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        var usuario = usuarioRepository.findById(id).orElseThrow();
        usuarioRepository.delete(usuario);
        return ResponseEntity.noContent().build();
    }
}
