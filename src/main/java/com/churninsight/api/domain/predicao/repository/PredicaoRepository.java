package com.churninsight.api.domain.predicao.repository;

import com.churninsight.api.domain.predicao.Predicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredicaoRepository extends JpaRepository<Predicao, Long> {
}
