package com.hackathon.churninsight.api.domain.usuario.dto;

/**
 * DTO responsável por encapsular o token JWT
 * retornado após uma autenticação bem-sucedida.
 *
 * Mantém a resposta simples e padronizada.
 */
public record TokenJWTDTO(

        /**
         * Token JWT gerado pelo sistema.
         */
        String token
) {}
