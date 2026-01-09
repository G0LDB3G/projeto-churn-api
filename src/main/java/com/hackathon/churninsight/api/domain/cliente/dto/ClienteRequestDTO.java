package com.hackathon.churninsight.api.domain.cliente.dto;

import com.hackathon.churninsight.api.domain.cliente.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ClienteRequestDTO(
        @NotBlank
        String gender,
        @NotNull
        Integer seniorCitizen,
        @NotBlank
        String partner,
        @NotBlank
        String dependents,
        @NotNull
        Integer tenure,
        @NotBlank
        String phoneService,
        @NotBlank
        String multipleLines,
        @NotBlank
        String internetService,
        @NotBlank
        String onlineSecurity,
        @NotBlank
        String onlineBackup,
        @NotBlank
        String deviceProtection,
        @NotBlank
        String techSupport,
        @NotBlank
        String streamingTV,
        @NotBlank
        String streamingMovies,
        @NotBlank
        String contract,
        @NotBlank
        String paperlessBilling,
        @NotBlank
        String paymentMethod,
        @NotNull
        BigDecimal monthlyCharges,
        @NotNull
        BigDecimal totalCharges) {

        public ClienteRequestDTO(Cliente dados) {
                this(dados.getGender(),
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
                        dados.getDependents(),
                        dados.getPaperlessBilling(),
                        dados.getPaymentMethod(),
                        dados.getMonthlyCharges(),
                        dados.getTotalCharges());
        }
}
