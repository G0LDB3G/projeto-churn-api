package com.hackathon.churninsight.api.domain.predicao.dto;

import com.hackathon.churninsight.api.domain.predicao.Predicao;

import java.time.LocalDateTime;

public record ListagemPredicaoDTO(
        Long id,
        String previsao,
        Double probabilidade,
        LocalDateTime data,
        Long idCliente) {

    public ListagemPredicaoDTO(Predicao predicao) {
        this(predicao.getId(), predicao.getPrevisao(), predicao.getProbabilidade(),
                predicao.getData(), predicao.getCliente().getId());
    }
}
