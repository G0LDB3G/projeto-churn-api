package com.hackathon.churninsight.api.domain.predicao;

import com.hackathon.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Predicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String previsao;

    private double probabilidade;

    public Predicao(PredicaoResponseDTO resultado) {
        this.previsao = resultado.getPrevisao();
        this.probabilidade = resultado.getProbabilidade();
    }
}
