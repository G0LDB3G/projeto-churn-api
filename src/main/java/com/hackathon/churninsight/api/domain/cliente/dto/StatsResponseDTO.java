package com.hackathon.churninsight.api.domain.cliente.dto;

/**
 * DTO responsável por representar as estatísticas gerais do sistema.
 * É usado como resposta no endpoint /stats.
 */
public record StatsResponseDTO(

        // Quantidade total de clientes cadastrados no sistema
        Long totalClientes,

        // Taxa de churn (ex: 0.25 = 25%)
        Double taxaChurn
) {}

