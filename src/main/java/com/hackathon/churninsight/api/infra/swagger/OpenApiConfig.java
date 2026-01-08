package com.hackathon.churninsight.api.infra.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração global do OpenAPI (Swagger)
 * com suporte à autenticação via JWT (Bearer Token).
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // Define o esquema de segurança JWT
        SecurityScheme securityScheme = new SecurityScheme()
                .name("bearer-key")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        return new OpenAPI()
                .info(new Info()
                        .title("ChurnInsight API")
                        .description("API de previsão de churn utilizando Inteligência Artificial")
                        .version("1.0"))
                // Aplica o esquema de segurança globalmente
                .addSecurityItem(new SecurityRequirement().addList("bearer-key"))
                .components(new Components()
                        .addSecuritySchemes("bearer-key", securityScheme)
                );
    }
}
