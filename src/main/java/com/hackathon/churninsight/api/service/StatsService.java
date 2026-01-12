package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.dto.StatsResponseDTO;
import com.hackathon.churninsight.api.domain.predicao.repository.PredicaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final PredicaoRepository predicaoRepository;


    public StatsResponseDTO obterEstatisticasGerais() {
        // Busca todas as predições realizadas
        var todasPredicoes = predicaoRepository.findAll();

        long totalConsultas = todasPredicoes.size();

        // Conta quantas predições o modelo classificou como "Yes"
        long totalRiscoChurn = todasPredicoes.stream()
                .filter(p -> "Yes".equalsIgnoreCase(p.getPrevisao()))
                .count();

        double taxaChurnPercentual = totalConsultas > 0
                ? ((double) totalRiscoChurn / totalConsultas) * 100
                : 0.0;

        return new StatsResponseDTO(totalConsultas, totalRiscoChurn, taxaChurnPercentual);
    }
}