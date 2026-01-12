package com.hackathon.churninsight.api.domain.cliente.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * DTO de entrada para cadastro/previsão de cliente.
 *
 * Esse DTO representa EXATAMENTE o JSON recebido na API.
 * Ele não possui regras de negócio, apenas validações básicas.
 */
public record ClienteRequestDTO(

        @NotBlank
        String customerID,

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
        BigDecimal totalCharges
) {}
