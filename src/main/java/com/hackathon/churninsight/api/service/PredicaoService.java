package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.predicao.dto.PredicaoResponseDTO;
import com.hackathon.churninsight.api.infra.client.ModeloPythonClient;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Serviço responsável por orquestrar
 * o processo completo de previsão de churn.
 */
@Service
public class PredicaoService {

    private final ConversaoDadosService conversaoDadosService;
    private final ModeloPythonClient modeloPythonClient;

    public PredicaoService(
            ConversaoDadosService conversaoDadosService,
            ModeloPythonClient modeloPythonClient
    ) {
        this.conversaoDadosService = conversaoDadosService;
        this.modeloPythonClient = modeloPythonClient;
    }

    /**
     * Executa a previsão de churn:
     * 1. Converte os dados
     * 2. Envia para o modelo Python
     */
    public PredicaoResponseDTO preverChurn(ClienteRequestDTO clienteDTO) {

        // 1. Converte os dados para features
        Map<String, Object> features =
                conversaoDadosService.processarCliente(clienteDTO);

        // 2. Chamada ao modelo de IA
        return modeloPythonClient.prever(features);
    }
}
