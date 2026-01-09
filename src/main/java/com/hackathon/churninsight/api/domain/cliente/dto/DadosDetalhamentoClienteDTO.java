package com.hackathon.churninsight.api.domain.cliente.dto;

import com.hackathon.churninsight.api.domain.cliente.Cliente;

import java.math.BigDecimal;

public record DadosDetalhamentoClienteDTO(
        Long id,
        String gender,
        Integer seniorCitizen,
        String partner,
        String dependents,
        Integer tenure,
        String phoneService,
        String multipleLines,
        String internetService,
        String onlineSecurity,
        String onlineBackup,
        String deviceProtection,
        String techSupport,
        String streamingTV,
        String streamingMovies,
        String contract,
        String paperlessBilling,
        String paymentMethod,
        BigDecimal monthlyCharges,
        BigDecimal totalCharges) {

    public DadosDetalhamentoClienteDTO(Cliente dados) {
        this(dados.getId(),
            dados.getGender(),
            dados.getSeniorCitizen(),
            dados.getPartner(),
            dados.getDependents(),
            dados.getTenure(),
            dados.getPhoneService(),
            dados.getMultipleLines(),
            dados.getInternetService(),
            dados.getOnlineSecurity(),
            dados.getOnlineBackup(),
            dados.getDeviceProtection(),
            dados.getTechSupport(),
            dados.getStreamingTV(),
            dados.getStreamingMovies(),
            dados.getContract(),
            dados.getPaperlessBilling(),
            dados.getPaymentMethod(),
            dados.getMonthlyCharges(),
            dados.getTotalCharges());
    }
}
