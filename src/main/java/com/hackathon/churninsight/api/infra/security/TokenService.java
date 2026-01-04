package com.hackathon.churninsight.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.hackathon.churninsight.api.domain.usuario.Usuario;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    private final String secret = "12345"; // temporário
    private final String issuer = "churninsight";

    public String gerarToken(Usuario cliente) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(cliente.getLogin())
                    .withClaim("id", cliente.getId())
                    .sign(algorithm);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Erro ao gerar JWT", ex);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            throw new RuntimeException("Token JWT inválido!", ex);
        }
    }
}
