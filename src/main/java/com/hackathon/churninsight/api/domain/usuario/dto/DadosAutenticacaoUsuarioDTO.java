package com.hackathon.churninsight.api.domain.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacaoUsuarioDTO(
        @NotBlank
        String login,
        @NotBlank
        String senha) {
}
