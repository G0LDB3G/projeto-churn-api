package com.hackathon.churninsight.api.domain.predicao;

import com.hackathon.churninsight.api.domain.cliente.Cliente;
import com.hackathon.churninsight.api.domain.predicao.dto.PredicaoResponseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity(name = "Predicao")
@Table(name = "predicoes")
public class Predicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String previsao;
    private Double probabilidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    Cliente cliente;

    @Column(name = "data_predicao")
    private LocalDateTime data;

    public Predicao(PredicaoResponseDTO resultado, Cliente cliente) {
        this.previsao = resultado.previsao();
        this.probabilidade = resultado.probabilidade();
        this.cliente = cliente;

        this.data = LocalDateTime.now();
    }
}