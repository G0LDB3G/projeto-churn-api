package com.hackathon.churninsight.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filtro responsável por interceptar todas as requisições
 * e validar o token JWT enviado no header Authorization.
 */
@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    public SecurityFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        try {
            // Recupera o token do header Authorization
            String tokenJWT = recuperarToken(request);

            // Se existir token, tenta validar
            if (tokenJWT != null) {

                // Valida o token (pode lançar exceção se estiver inválido ou expirado)
                String subject = tokenService.validarToken(tokenJWT);

                // Cria autenticação para o Spring Security
                var authentication =
                        new UsernamePasswordAuthenticationToken(
                                subject,
                                null,
                                null
                        );

                // Define o usuário autenticado no contexto de segurança
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            // Continua o fluxo normal da requisição
            filterChain.doFilter(request, response);

        } catch (Exception ex) {
            // Qualquer erro no token (expirado, inválido, etc)

            // Limpa o contexto de segurança
            SecurityContextHolder.clearContext();

            // Retorna 401 (não autenticado)
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    /**
     * Extrai o token JWT do header Authorization.
     * Espera o formato: Bearer <token>
     */
    private String recuperarToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return null;
        }

        return authorizationHeader.replace("Bearer ", "");
    }
}
