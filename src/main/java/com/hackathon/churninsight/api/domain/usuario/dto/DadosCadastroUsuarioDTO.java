package com.hackathon.churninsight.api.domain.usuario.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO utilizado no cadastro de novos usuários.
 *
 * Apesar de hoje possuir os mesmos campos do DTO
 * de autenticação, ele representa um contexto
 * diferente (criação de usuário).
 *
 * Isso facilita a evolução futura, como:
 * - confirmação de senha
 * - e-mail
 * - regras adicionais de validação
 */
public record DadosCadastroUsuarioDTO(

        /**
         * Login do usuário.
         * Deve ser único no sistema.
         */
        @NotBlank
        String login,

        /**
         * Senha do usuário.
         * Será armazenada de forma criptografada.
         */
        @NotBlank
        String senha
) {}


