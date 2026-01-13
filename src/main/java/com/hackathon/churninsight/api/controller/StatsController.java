package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.cliente.dto.StatsResponseDTO;
import com.hackathon.churninsight.api.service.StatsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsável por fornecer estatísticas
 * agregadas sobre as previsões realizadas.
 *
 * Usado principalmente para dashboards e métricas.
 */


@RestController
@RequestMapping("/api/stats")
@SecurityRequirement(name = "bearer-key")
public class StatsController {

    private final StatsService service;

    public StatsController(StatsService service) {
        this.service = service;
    }

    /**
     * Retorna estatísticas gerais do sistema, como:
     * - total de previsões
     * - quantidade de churn
     * - taxa percentual de churn
     */

    @GetMapping
    public ResponseEntity<StatsResponseDTO> obterEstatisticas() {
        return ResponseEntity.ok(service.obterEstatisticasGerais());
    }
}