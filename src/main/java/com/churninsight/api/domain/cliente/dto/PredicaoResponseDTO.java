package com.churninsight.api.domain.cliente.dto;

public class PredicaoResponseDTO {

    private String previsao;
    private double probabilidade;

    public PredicaoResponseDTO(String previsao, double probabilidade) {
        this.previsao = previsao;
        this.probabilidade = probabilidade;
    }

    public String getPrevisao() {
        return previsao;
    }

    public double getProbabilidade() {
        return probabilidade;
    }
}

