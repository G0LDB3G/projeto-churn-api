package com.hackathon.churninsight.api.infra.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.churninsight.api.infra.exception.ErroRespostaDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * EntryPoint customizado para autenticação.
 *
 * Essa classe é acionada automaticamente pelo Spring Security
 * quando uma requisição tenta acessar um endpoint protegido
 * sem autenticação válida (token JWT ausente ou inválido).
 *
 * Em vez de retornar a resposta padrão do Spring Security (HTML),
 * ela devolve um JSON padronizado, facilitando o consumo por front-end
 * ou outras APIs.
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    // ObjectMapper usado para converter objetos Java em JSON
    private final ObjectMapper mapper;

    public CustomAuthenticationEntryPoint(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Método chamado quando ocorre uma falha de autenticação.
     *
     * Exemplo de cenários:
     * - Token JWT não enviado
     * - Token JWT inválido
     * - Token JWT expirado
     *
     * @param request requisição HTTP original
     * @param response resposta HTTP que será enviada ao cliente
     * @param authException exceção lançada pelo Spring Security
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        // Cria um objeto de erro padronizado
        ErroRespostaDTO erroResposta = new ErroRespostaDTO(
                401,
                "Unauthorized",
                "Token ausente ou inválido"
        );

        // Define o status HTTP 401 (não autorizado)
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // Define que a resposta será em JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Converte o objeto de erro em JSON
        String json = mapper.writeValueAsString(erroResposta);

        // Escreve o JSON no corpo da resposta
        response.getWriter().write(json);
    }
}
