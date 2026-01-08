package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.cliente.dto.StatsResponseDTO;
import com.hackathon.churninsight.api.service.StatsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsável por estatísticas do sistema.
 * Muito importante para apresentação do MVP.
 */
@RestController
@RequestMapping("/stats")
@SecurityRequirement(name = "bearer-key")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    /**
     * Retorna estatísticas básicas do sistema:
     * - total de previsões
     * - taxa de churn
     */
    @GetMapping
    public StatsResponseDTO obterEstatisticas() {
        return statsService.obterStats();
    }
}

