package com.hackathon.churninsight.api.domain.cliente.dto;

public class ClienteFeaturesDTO {

    private Integer tempoContratoMeses;
    private Integer atrasosDePagamento;
    private Double usoMensal;
    private String plano;

    public ClienteFeaturesDTO(
            Integer tempoContratoMeses,
            Integer atrasosDePagamento,
            Double usoMensal,
            String plano
    ) {
        this.tempoContratoMeses = tempoContratoMeses;
        this.atrasosDePagamento = atrasosDePagamento;
        this.usoMensal = usoMensal;
        this.plano = plano;
    }

    public Integer getTempoContratoMeses() {
        return tempoContratoMeses;
    }

    public Integer getAtrasosDePagamento() {
        return atrasosDePagamento;
    }

    public Double getUsoMensal() {
        return usoMensal;
    }

    public String getPlano() {
        return plano;
    }
}
