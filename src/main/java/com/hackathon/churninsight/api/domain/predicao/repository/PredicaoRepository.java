package com.hackathon.churninsight.api.domain.predicao.repository;

import com.hackathon.churninsight.api.domain.predicao.Predicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredicaoRepository extends JpaRepository<Predicao, Long> {
}
