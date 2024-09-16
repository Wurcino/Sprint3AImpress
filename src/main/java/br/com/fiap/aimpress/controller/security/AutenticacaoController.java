package br.com.fiap.aimpress.controller.security;

import br.com.fiap.aimpress.dto.security.autenticacao.DadosLoginDto;
import br.com.fiap.aimpress.dto.security.autenticacao.TokenJwtDto;
import br.com.fiap.aimpress.model.user.User;
import br.com.fiap.aimpress.service.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@Tag(name = "Autenticação", description = "Operations related to authentication")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJwtDto> post(@RequestBody @Valid DadosLoginDto dto){
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var authenticate = authenticationManager.authenticate(autenticacaoToken);
        var token = tokenService.gerarToken((User) authenticate.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDto(token));
    }
}
