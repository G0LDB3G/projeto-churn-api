package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.dto.StatsResponseDTO;
import org.springframework.stereotype.Service;

/**
 * Service responsável por estatísticas gerais do sistema.
 * No momento está simples (MVP), mas pronto para evoluir.
 */
@Service
public class StatsService {

    /**
     * Retorna estatísticas gerais.
     * Futuramente pode buscar dados reais do banco.
     */
    public StatsResponseDTO obterStats() {

        // Valores mockados por enquanto
        Long totalClientes = 0L;
        Double taxaChurn = 0.0;

        return new StatsResponseDTO(
                totalClientes,
                taxaChurn
        );
    }
}


