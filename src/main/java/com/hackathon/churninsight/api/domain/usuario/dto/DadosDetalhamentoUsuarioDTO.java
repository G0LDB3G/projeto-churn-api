package com.hackathon.churninsight.api.domain.usuario.dto;

import com.hackathon.churninsight.api.domain.usuario.Usuario;

public record DadosDetalhamentoUsuarioDTO(
        Long id,
        String login,
        String senha) {

    public DadosDetalhamentoUsuarioDTO(Usuario dadosUsuario) {
        this(dadosUsuario.getId(), dadosUsuario.getLogin(), dadosUsuario.getSenha());
    }
}
