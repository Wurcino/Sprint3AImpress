package br.com.fiap.aimpress.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

// para o teste de documentação Swagger use este link: http://localhost:8080/swagger-ui/index.html

@OpenAPIDefinition(
        info = @Info(contact = @Contact(name = "AImpress", email = "rm550200@fiap.com.br"),
                title = "FIAP AImpress",
                description = "Sistema de Ajuda a criação de curriculos",
                version = "1.0"),
        servers = @Server(url = "http://localhost:8080"),
        security = @SecurityRequirement(name = "churrosJwt")
)
@SecurityScheme(
        name = "aimpressJwt",
        description = "Segurança JWT",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}