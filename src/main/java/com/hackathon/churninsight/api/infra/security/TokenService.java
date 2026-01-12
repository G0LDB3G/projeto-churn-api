package com.hackathon.churninsight.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * Serviço responsável por gerar e validar tokens JWT.
 */
@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    /**
     * Gera um token JWT com validade de 2 horas
     */
    public String gerarToken(String login) {
        return JWT.create()
                .withIssuer("churninsight-api")
                .withSubject(login)
                .withExpiresAt(Instant.now().plusSeconds(7200))
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * Valida o token JWT e retorna o login do usuário.
     */
    public String validarToken(String tokenJWT) {
        return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("churninsight-api")
                .build()
                .verify(tokenJWT)
                .getSubject();
    }
}
