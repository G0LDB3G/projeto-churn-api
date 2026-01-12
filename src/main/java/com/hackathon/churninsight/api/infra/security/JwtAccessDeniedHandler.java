//package com.hackathon.churninsight.api.infra.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Map;
//
///**
// * Handler responsável por tratar erros 403 (Forbidden).
// *
// * É acionado quando um usuário tenta acessar
// * um recurso sem permissão ou sem autenticação válida.
// */
//@Component
//public class JwtAccessDeniedHandler implements AccessDeniedHandler {
//
//    @Override
//    public void handle(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            AccessDeniedException accessDeniedException
//    ) throws IOException, ServletException {
//
//        response.setStatus(HttpStatus.FORBIDDEN.value());
//        response.setContentType("application/json");
//
//        Map<String, Object> body = Map.of(
//                "timestamp", LocalDateTime.now()
//                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
//                "status", 403,
//                "erro", "Forbidden",
//                "detalhes", new String[]{
//                        "Acesso negado. Token ausente ou permissoes insuficientes."
//                }
//        );
//
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(
//                mapper.writeValueAsString(body)
//        );
//    }
//}
//
