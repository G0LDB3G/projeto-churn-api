package com.hackathon.churninsight.api.infra.configdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfigurations {
    @Bean
    public OpenAPI cunstomOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Churninsight")
                        .description("API Rest da aplicação Churninsight, contendo a funcionalidade de previsão de cancelamento de clientes.")
                        .contact(new Contact()
                                .name("nome")
                                .email("email"))
                        .license(new License()
                                .name("Nome licença")
                                .url("url licença")));
    }
}
