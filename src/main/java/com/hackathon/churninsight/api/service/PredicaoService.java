package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.Cliente;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.predicao.Predicao;
import com.hackathon.churninsight.api.domain.predicao.dto.PredicaoResponseDTO;
import com.hackathon.churninsight.api.domain.cliente.repository.ClienteRepository;
import com.hackathon.churninsight.api.domain.predicao.repository.PredicaoRepository;
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
    private final PredicaoRepository predicaoRepository;
    private final ClienteRepository clienteRepository;

    public PredicaoService(
            ConversaoDadosService conversaoDadosService,
            ModeloPythonClient modeloPythonClient,
            PredicaoRepository predicaoRepository,
            ClienteRepository clienteRepository
    ) {
        this.conversaoDadosService = conversaoDadosService;
        this.modeloPythonClient = modeloPythonClient;
        this.predicaoRepository = predicaoRepository;
        this.clienteRepository = clienteRepository;
    }

    /**
     * Executa a previsão de churn:
     * 1. Converte os dados
     * 2. Envia para o modelo Python
     * 3. Salva a previsão
     * 4. Salva o cliente (se não existir)
     */
    public PredicaoResponseDTO preverChurn(ClienteRequestDTO clienteDTO) {

        // 1. Converte os dados para features
        Map<String, Object> features =
                conversaoDadosService.processarCliente(clienteDTO);

        // 2. Chamada ao modelo de IA
        PredicaoResponseDTO resultado =
                modeloPythonClient.prever(features);

        // 3. Salva a previsão no banco
//        Predicao predicao = new Predicao(resultado);
//        predicaoRepository.save(predicao);

        // 4. Salva o cliente apenas se não existir
//        if (!clienteRepository.existsByCustomerID(clienteDTO.customerID())) {
//            Cliente cliente = new Cliente(clienteDTO);
//            clienteRepository.save(cliente);
//        }

        return resultado;
    }
}
