package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteFeaturesDTO;
import org.springframework.stereotype.Service;

@Service
public class ConversaoDadosService {

    public ClienteFeaturesDTO processarCliente(ClienteRequestDTO dados) {

        return new ClienteFeaturesDTO(
                dados.getTempoContratoMeses(),
                dados.getAtrasosDePagamento(),
                dados.getUsoMensal(),
                dados.getPlano()
        );
    }
}
