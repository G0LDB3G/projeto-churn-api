package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.dto.StatsResponseDTO;
import com.hackathon.churninsight.api.domain.predicao.Predicao;
import com.hackathon.churninsight.api.domain.predicao.repository.PredicaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Serviço responsável por gerar estatísticas gerais
 * sobre as previsões de churn realizadas pela API.
 *
 * Essas informações podem ser usadas para:
 * - Monitorar a taxa média de churn prevista
 * - Avaliar o comportamento do modelo ao longo do tempo
 * - Exibir métricas em dashboards ou relatórios
 */
@Service
@RequiredArgsConstructor
public class StatsService {

    // Repositório responsável por acessar as previsões armazenadas
    private final PredicaoRepository predicaoRepository;

    /**
     * Calcula estatísticas gerais das previsões:
     *
     * - totalConsultas: quantidade total de previsões realizadas
     * - totalChurn: quantidade de clientes com previsão "Vai cancelar"
     * - taxaPercentual: média das probabilidades de churn
     *   apenas dos clientes que tiveram previsão positiva
     *
     * @return objeto StatsResponseDTO com os dados consolidados
     */
    public StatsResponseDTO obterEstatisticasGerais() {

        // Recupera todas as previsões salvas no banco
        var todasPredicoes = predicaoRepository.findAll();

        // Total de previsões realizadas
        long totalConsultas = todasPredicoes.size();

        // Conta quantas previsões indicam churn
        long totalChurn = todasPredicoes.stream()
                .filter(p -> "Vai cancelar".equalsIgnoreCase(p.getPrevisao()))
                .count();

        // Soma das probabilidades de churn apenas
        // para clientes classificados como "Vai cancelar"
        double totalProbabilidadeChurn = todasPredicoes.stream()
                .filter(p -> "Vai cancelar".equalsIgnoreCase(p.getPrevisao()))
                .mapToDouble(Predicao::getProbabilidade)
                .sum();

        /**
         * Calcula a média da probabilidade de churn:
         *
         * - Divide a soma das probabilidades pelo total de churns
         * - Arredonda para duas casas decimais
         * - Evita divisão por zero
         */
        double taxaPercentual = totalChurn > 0
                ? BigDecimal
                .valueOf(totalProbabilidadeChurn / totalChurn)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue()
                : 0.0;

        // Retorna o DTO com as estatísticas calculadas
        return new StatsResponseDTO(
                totalConsultas,
                totalChurn,
                taxaPercentual
        );
    }
}
