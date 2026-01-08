package com.hackathon.churninsight.api.domain.predicao;

import com.hackathon.churninsight.api.domain.predicao.dto.PredicaoResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Entidade Predicao
 * Representa uma previsão de churn realizada pelo sistema.
 */
@Entity
@Table(name = "predicoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Predicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Resultado da previsão (ex: "Vai cancelar")
     */
    private String previsao;

    /**
     * Probabilidade calculada pelo modelo
     */
    private Double probabilidade;

    /**
     * Data/hora da previsão
     */
    private LocalDateTime dataPredicao;

    /**
     * Construtor usado pelo serviço de predição
     */
    public Predicao(PredicaoResponseDTO dto) {
        this.previsao = dto.previsao();
        this.probabilidade = dto.probabilidade();
        this.dataPredicao = LocalDateTime.now();
    }
}
