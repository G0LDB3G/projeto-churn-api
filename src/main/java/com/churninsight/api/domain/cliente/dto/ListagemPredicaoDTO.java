package com.churninsight.api.domain.cliente.dto;

import com.churninsight.api.domain.predicao.Predicao;

public record ListagemPredicaoDTO(
        Long id,
        String previsao,
        Double probabilidade) {

    public ListagemPredicaoDTO(Predicao predicao) {
        this(predicao.getId(), predicao.getPrevisao(), predicao.getProbabilidade());
    }
}
