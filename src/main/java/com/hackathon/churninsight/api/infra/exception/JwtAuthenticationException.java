package com.hackathon.churninsight.api.infra.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Exceção personalizada para erros relacionados ao JWT.
 *
 * Ela herda de AuthenticationException para que o
 * Spring Security reconheça como erro de autenticação.
 */
public class JwtAuthenticationException extends AuthenticationException {

    /**
     * Construtor usado quando queremos encadear a exceção original
     * (ex: JWTVerificationException).
     */
    public JwtAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
