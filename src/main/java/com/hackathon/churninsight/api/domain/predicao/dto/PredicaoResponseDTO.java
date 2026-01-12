package com.hackathon.churninsight.api.domain.predicao.dto;

import com.hackathon.churninsight.api.domain.predicao.Predicao;

import java.time.LocalDateTime;

/**
 * DTO usado como resposta da predição feita pelo modelo de IA.
 * Ele é retornado para o controller e depois para o cliente.
 */
public record PredicaoResponseDTO(
        Long id,
        String previsao,
        Double probabilidade,
        LocalDateTime data
) {
    public PredicaoResponseDTO(Predicao predicao) {
        this(predicao.getId(), predicao.getPrevisao(), predicao.getProbabilidade(), predicao.getDataPredicao());
    }
}

