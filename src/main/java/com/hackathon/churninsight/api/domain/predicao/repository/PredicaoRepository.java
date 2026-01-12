package com.hackathon.churninsight.api.domain.predicao.repository;

import com.hackathon.churninsight.api.domain.predicao.Predicao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de Predição
 */
public interface PredicaoRepository extends JpaRepository<Predicao, Long> {

    /**
     * Retorna a quantidade total de previsões realizadas
     */
    long count();
}
