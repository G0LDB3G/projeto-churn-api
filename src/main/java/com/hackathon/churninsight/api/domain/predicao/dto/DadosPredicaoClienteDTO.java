package com.hackathon.churninsight.api.domain.predicao.dto;

import com.hackathon.churninsight.api.domain.cliente.Cliente;
import com.hackathon.churninsight.api.domain.cliente.dto.DadosDetalhamentoClienteDTO;
import com.hackathon.churninsight.api.domain.predicao.Predicao;

import java.time.LocalDateTime;

public record DadosPredicaoClienteDTO(
        Long id,
        String previsao,
        Double probabilidade,
        LocalDateTime dataPredicao,
        DadosDetalhamentoClienteDTO dadosCliente) {

    public DadosPredicaoClienteDTO(Predicao dadosPredicao, Cliente dadosCliente) {
        this(dadosPredicao.getId(),
                dadosPredicao.getPrevisao(),
                dadosPredicao.getProbabilidade(),
                dadosPredicao.getDataPredicao(),
                new DadosDetalhamentoClienteDTO(dadosCliente));
    }
}
