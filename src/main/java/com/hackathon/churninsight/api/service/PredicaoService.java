package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.Cliente;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import com.hackathon.churninsight.api.domain.cliente.repository.ClienteRepository;
import com.hackathon.churninsight.api.domain.predicao.Predicao;
import com.hackathon.churninsight.api.domain.predicao.repository.PredicaoRepository;
import com.hackathon.churninsight.api.infra.client.ModeloPythonClient;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    public PredicaoResponseDTO preverChurn(ClienteRequestDTO clienteDTO) {

        // Converte dados para features
        Map<String, Object> features =
                conversaoDadosService.processarCliente(clienteDTO);

        // Chama o modelo Python
        PredicaoResponseDTO resultado =
                modeloPythonClient.prever(features);

        // Salva previsão
        Predicao predicao = new Predicao(resultado);
        predicaoRepository.save(predicao);

        // Salva cliente apenas se não existir
        if (!clienteRepository.existsByCustomerID(clienteDTO.customerID())) {
            Cliente cliente = new Cliente(clienteDTO);
            clienteRepository.save(cliente);
        }

        return resultado;
    }
}
