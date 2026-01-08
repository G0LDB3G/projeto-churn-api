package com.hackathon.churninsight.api.domain.predicao.dto;

import com.hackathon.churninsight.api.domain.predicao.Predicao;

/**
 * DTO usado para listagem paginada de predições.
 * Ele converte automaticamente a entidade Predicao.
 */
public record ListagemPredicaoDTO(
        Long id,
        String previsao,
        Double probabilidade
) {

    public ListagemPredicaoDTO(Predicao predicao) {
        this(
                predicao.getId(),
                predicao.getPrevisao(),
                predicao.getProbabilidade()
        );
    }
}

