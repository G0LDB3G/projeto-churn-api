package com.hackathon.churninsight.api.domain.cliente.dto;

/**
 * DTO simples para retorno de cliente.
 * Usado para não expor a entidade inteira.
 */
public record ClienteResponseDTO(
        Long id,
        String customerID
) {}


