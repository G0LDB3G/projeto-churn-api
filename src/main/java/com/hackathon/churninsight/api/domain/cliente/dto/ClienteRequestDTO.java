package com.hackathon.churninsight.api.domain.cliente.dto;

import jakarta.validation.constraints.NotNull;

public class ClienteRequestDTO {
//Criar: {
//"customerID": "7590-VHVEG",
//"gender": "Female",
//"SeniorCitizen": 0,
//"Partner": "Yes",
//"Dependents": "No",
//"tenure": 1,
//"PhoneService": "No",
//"MultipleLines": "No phone service",
//"InternetService": "DSL",
//"OnlineSecurity": "No",
//"OnlineBackup": "Yes",
//"DeviceProtection": "No",
//"TechSupport": "No",
//"StreamingTV": "No",
//"StreamingMovies": "No",
//"Contract": "Month-to-month",
//"PaperlessBilling": "Yes",
//"PaymentMethod": "Electronic check",
//"MonthlyCharges": 29.85,
//"TotalCharges": 29.85
//}
    @NotNull(message = "tempo_contrato_meses é obrigatório")
    private Integer tempoContratoMeses;

    @NotNull(message = "atrasos_de_pagamento é obrigatório")
    private Integer atrasosDePagamento;

    @NotNull(message = "uso_mensal é obrigatório")
    private Double usoMensal;

    @NotNull(message = "plano é obrigatório")
    private String plano;

    public Integer getTempoContratoMeses() {
        return tempoContratoMeses;
    }

    public void setTempoContratoMeses(Integer tempoContratoMeses) {
        this.tempoContratoMeses = tempoContratoMeses;
    }

    public Integer getAtrasosDePagamento() {
        return atrasosDePagamento;
    }

    public void setAtrasosDePagamento(Integer atrasosDePagamento) {
        this.atrasosDePagamento = atrasosDePagamento;
    }

    public Double getUsoMensal() {
        return usoMensal;
    }

    public void setUsoMensal(Double usoMensal) {
        this.usoMensal = usoMensal;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }
}