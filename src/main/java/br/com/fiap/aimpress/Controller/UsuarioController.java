package br.com.fiap.aimpress.Controller;

import br.com.fiap.aimpress.Domain.Usuario;
import br.com.fiap.aimpress.dto.Usuario.AtualizarUsuarioDTO;
import br.com.fiap.aimpress.dto.Usuario.CadastroUsuarioDTO;
import br.com.fiap.aimpress.dto.Usuario.DetalhesUsuarioDTO;
import br.com.fiap.aimpress.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping // Endpoint para cadastrar um novo usuário
    @Transactional
    public ResponseEntity<DetalhesUsuarioDTO> cadastrar(@RequestBody @Valid CadastroUsuarioDTO dto, UriComponentsBuilder builder) {
        var usuario = new Usuario(dto); // Cria um novo usuário com base nos dados recebidos no DTO
        usuario = usuarioRepository.save(usuario); // Salva o usuário no banco de dados
        var uri = builder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri(); // Constrói a URI para o novo usuário criado
        return ResponseEntity.created(uri).body(new DetalhesUsuarioDTO(usuario)); // Retorna a resposta com o status 201 Created e os detalhes do usuário criado
    }

    @GetMapping("/{id}") // Endpoint para detalhar um usuário existente
    public ResponseEntity<DetalhesUsuarioDTO> detalhar(@PathVariable Long id) {
        var usuario = usuarioRepository.findById(id).orElseThrow(); // Busca o usuário pelo ID fornecido
        return ResponseEntity.ok(new DetalhesUsuarioDTO(usuario)); // Retorna os detalhes do usuário encontrado
    }

    @PutMapping("/{id}") // Endpoint para atualizar um usuário existente
    @Transactional
    public ResponseEntity<DetalhesUsuarioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarUsuarioDTO dto) {
        var usuario = usuarioRepository.findById(id).orElseThrow(); // Busca o usuário pelo ID fornecido
        usuario.atualizar(dto); // Atualiza os dados do usuário com base nos dados fornecidos no DTO
        return ResponseEntity.ok(new DetalhesUsuarioDTO(usuario)); // Retorna os detalhes do usuário atualizado
    }

    @DeleteMapping("/{id}") // Endpoint para deletar um usuário existente
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        var usuario = usuarioRepository.findById(id).orElseThrow(); // Busca o usuário pelo ID fornecido
        usuarioRepository.delete(usuario); // Deleta o usuário do banco de dados
        return ResponseEntity.noContent().build(); // Retorna a resposta com o status 204 No Content, indicando que a operação foi bem-sucedida
    }
}