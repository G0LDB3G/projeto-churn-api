package com.hackathon.churninsight.api.infra.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.churninsight.api.infra.exception.ErroRespostaDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper mapper;

    public CustomAuthenticationEntryPoint(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        ErroRespostaDTO erroResposta = new ErroRespostaDTO(401, "Unauthorized", "Token ausente ou inválido");

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String json = mapper.writeValueAsString(erroResposta);
        response.getWriter().write(json);
    }
}
