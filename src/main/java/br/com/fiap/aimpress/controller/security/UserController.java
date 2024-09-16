package br.com.fiap.aimpress.controller.security;

import br.com.fiap.aimpress.dto.security.CadastroUserDto;
import br.com.fiap.aimpress.dto.security.DetalhesUserDto;
import br.com.fiap.aimpress.model.user.User;
import br.com.fiap.aimpress.repository.user.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("auth")

@Tag(name = "User", description = "Operations related to user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("registrar")
    @Transactional
    @Operation(summary = "Register a new user", description = "Register a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User registered"),
            @ApiResponse(responseCode = "400", description = "Invalid data")
    })
    public ResponseEntity<DetalhesUserDto> registrar(@RequestBody @Valid CadastroUserDto dto,
                                                    UriComponentsBuilder builder) {
        var user = new User(dto.username(), passwordEncoder.encode(dto.password()), dto.email());
        userRepository.save(user);
        var url = builder.path("auth/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesUserDto(user));
    }

    @GetMapping("user/{id}")
    @Operation(summary = "Get a user by ID", description = "returns a user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<DetalhesUserDto> getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return ResponseEntity.ok(new DetalhesUserDto(user));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("users")
    @Operation(summary = "Get all users", description = "returns all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "404", description = "Users not found")
    })
    public ResponseEntity<List<DetalhesUserDto>> listar(Pageable pageable){
        var lista = userRepository.findAll(pageable)
                .stream().map(DetalhesUserDto::new).toList();
        return ResponseEntity.ok(lista);
    }

}