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
    private long totalConsultas;
    private long totalChurn;
    private double taxaPercentual;
}
