package com.hackathon.churninsight.api.domain.predicao.dto;

/**
 * DTO usado como resposta da predição feita pelo modelo de IA.
 * Ele é retornado para o controller e depois para o cliente.
 */
public record PredicaoResponseDTO(
        String previsao,
        Double probabilidade
) {}

