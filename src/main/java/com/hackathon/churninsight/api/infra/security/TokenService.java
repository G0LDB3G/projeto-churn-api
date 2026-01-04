package com.hackathon.churninsight.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hackathon.churninsight.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer("churninsight-api")
                .withSubject(usuario.getLogin())
                .withExpiresAt(Instant.now().plusSeconds(7200)) // 2h
                .sign(Algorithm.HMAC256(secret));
    }

    public String validarToken(String token) {
        return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("churninsight-api")
                .build()
                .verify(token)
                .getSubject();
    }
}

