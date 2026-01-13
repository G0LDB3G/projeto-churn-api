package com.hackathon.churninsight.api.domain.cliente.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO responsável por representar as estatísticas gerais do sistema.
 * É usado como resposta no endpoint /stats.
 */


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatsResponseDTO {
    /**
     * Total de previsões realizadas.
     */
    private long totalConsultas;

    /**
     * Total de clientes previstos como churn.
     */
    private long totalChurn;

    /**
     * Taxa percentual de churn.
     */
    private double taxaPercentual;

}
