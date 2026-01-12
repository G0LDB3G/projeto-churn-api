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

        var todasPredicoes = predicaoRepository.findAll();

        long totalConsultas = todasPredicoes.size();

        long totalChurn = todasPredicoes.stream()
                .filter(p -> "Vai cancelar".equalsIgnoreCase(p.getPrevisao()))
                .count();

        double taxaPercentual = totalConsultas > 0
                ? Math.round(((double) totalChurn / totalConsultas) * 100 * 100.0) / 100.0
                : 0.0;


        return new StatsResponseDTO(
                totalConsultas,
                totalChurn,
                taxaPercentual
        );
    }
}

