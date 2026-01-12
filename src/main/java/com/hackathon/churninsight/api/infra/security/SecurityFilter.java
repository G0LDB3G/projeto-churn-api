package com.hackathon.churninsight.api.infra.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.hackathon.churninsight.api.infra.exception.JwtAuthenticationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filtro responsável por interceptar todas as requisições
 * e validar o token JWT.
 */
@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final AuthenticationEntryPointFailureHandler failureHandler;

    public SecurityFilter(
            TokenService tokenService,
            CustomAuthenticationEntryPoint entryPoint
    ) {
        this.tokenService = tokenService;

        // Responsável por delegar o erro ao EntryPoint
        this.failureHandler =
                new AuthenticationEntryPointFailureHandler(entryPoint);
    }

    /**
     * Executado uma vez por requisição.
     */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        try {
            // Recupera o token do header Authorization
            String tokenJWT = recuperarToken(request);

            // Se existir token, tenta validar
            if (tokenJWT != null) {

                // Extrai o subject (ex: email ou id do usuário)
                String subject = tokenService.validarToken(tokenJWT);

                // Cria objeto de autenticação
                var authentication =
                        new UsernamePasswordAuthenticationToken(
                                subject,
                                null,
                                null
                        );

                // Registra o usuário como autenticado
                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }

            // Continua o fluxo da requisição
            filterChain.doFilter(request, response);

        } catch (JWTVerificationException ex) {

            // Limpa qualquer autenticação parcial
            SecurityContextHolder.clearContext();

            // Converte erro de JWT em erro de autenticação
            var authException = new JwtAuthenticationException(
                    "Token invalido, expirado ou malformado",
                    ex
            );

            // Delega o tratamento do erro
            failureHandler.onAuthenticationFailure(
                    request,
                    response,
                    authException
            );
        }
    }

    /**
     * Extrai o token do header Authorization.
     */
    private String recuperarToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            return null;
        }

        return header.replace("Bearer ", "");
    }
}
