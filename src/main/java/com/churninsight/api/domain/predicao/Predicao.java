package com.churninsight.api.domain.predicao;

import com.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity(name = "Predicao")
@Table(name = "predicoes")
public class Predicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String previsao;
    private Double probabilidade;

    public Predicao(PredicaoResponseDTO resultado) {
        this.previsao = resultado.getPrevisao();
        this.probabilidade = resultado.getProbabilidade();
    }
}
