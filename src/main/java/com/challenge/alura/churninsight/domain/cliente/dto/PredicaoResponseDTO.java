package com.challenge.alura.churninsight.domain.cliente.dto;

import lombok.Value;

@Value // Cria campos private final, getters e construtor com todos os campos (Imutável)
public class PredicaoResponseDTO {
    String previsao;
    Double probabilidade;
}

