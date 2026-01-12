package com.hackathon.churninsight.api.domain.usuario.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO utilizado no processo de autenticação (login).
 *
 * Representa os dados mínimos necessários para que
 * um usuário se autentique no sistema.
 *
 * É propositalmente simples, pois o login deve ser
 * rápido e direto.
 */
public record DadosAutenticacaoDTO(

        /**
         * Login do usuário.
         * Não pode ser nulo nem vazio.
         */
        @NotBlank
        String login,

        /**
         * Senha do usuário.
         * Não pode ser nula nem vazia.
         */
        @NotBlank
        String senha
) {}


