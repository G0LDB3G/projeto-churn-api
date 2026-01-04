package com.hackathon.churninsight.api.domain.cliente;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity(name = "Cliente")
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tempoContratoMeses;
    private Integer atrasosDePagamento;
    private Double usoMensal;
    private String plano;

    public Cliente(ClienteRequestDTO clienteDTO) {
        this.tempoContratoMeses = clienteDTO.getTempoContratoMeses();
        this.atrasosDePagamento = clienteDTO.getAtrasosDePagamento();
        this.usoMensal = clienteDTO.getUsoMensal();
        this.plano = clienteDTO.getPlano();
    }
}