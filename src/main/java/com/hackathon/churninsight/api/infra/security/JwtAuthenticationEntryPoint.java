//package com.hackathon.churninsight.api.infra.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Map;
//
///**
// * Classe responsável por tratar erros de autenticação.
// *
// * Ela é chamada automaticamente pelo Spring Security
// * quando uma AuthenticationException acontece (ex: token inválido).
// */
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    /**
//     * Método executado sempre que uma requisição NÃO autenticada
//     * tenta acessar um recurso protegido.
//     */
//    @Override
//    public void commence(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            AuthenticationException authException
//    ) throws IOException, ServletException {
//
//        // Define o status HTTP 401 (Não autorizado)
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//
//        // Define que a resposta será em JSON
//        response.setContentType("application/json");
//
//        // Corpo da resposta padronizado
//        Map<String, Object> body = Map.of(
//                // Data e hora do erro
//                "timestamp", LocalDateTime.now()
//                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
//
//                // Código HTTP
//                "status", 401,
//
//                // Tipo do erro
//                "erro", "Unauthorized",
//
//                // Mensagens detalhadas do erro
//                "detalhes", new String[]{
//                        "Token inválido, expirado ou malformado"
//                }
//        );
//
//        // Converte o Map em JSON
//        ObjectMapper mapper = new ObjectMapper();
//
//        // Escreve o JSON no corpo da resposta
//        response.getWriter().write(
//                mapper.writeValueAsString(body)
//        );
//    }
//}
