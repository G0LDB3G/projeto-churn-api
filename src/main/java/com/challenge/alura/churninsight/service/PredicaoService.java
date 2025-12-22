package com.challenge.alura.churninsight.service;

import com.challenge.alura.churninsight.domain.cliente.dto.ClienteRequestDTO;
import com.challenge.alura.churninsight.domain.cliente.dto.PredicaoResponseDTO;
import com.challenge.alura.churninsight.infra.client.ModeloPythonClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PredicaoService {

    private final ModeloPythonClient modeloClient;

    public PredicaoResponseDTO preverChurn(ClienteRequestDTO clienteDTO) {
        // Aqui poderíamos salvar os dados no banco antes de chamar o modelo
        return modeloClient.buscarPredicao(clienteDTO);
    }
}

