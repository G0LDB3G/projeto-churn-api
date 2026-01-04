package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteFeaturesDTO;
import com.hackathon.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import com.hackathon.churninsight.api.domain.predicao.Predicao;
import com.hackathon.churninsight.api.domain.predicao.repository.PredicaoRepository;
import com.hackathon.churninsight.api.infra.client.ModeloPythonClient;
import org.springframework.stereotype.Service;

@Service
public class PredicaoService {

    private final ConversaoDadosService conversaoDadosService;
    private final ModeloPythonClient modeloPythonClient;
    private final PredicaoRepository predicaoRepository;

    public PredicaoService(
            ConversaoDadosService conversaoDadosService,
            ModeloPythonClient modeloPythonClient,
            PredicaoRepository predicaoRepository
    ) {
        this.conversaoDadosService = conversaoDadosService;
        this.modeloPythonClient = modeloPythonClient;
        this.predicaoRepository = predicaoRepository;
    }

    public PredicaoResponseDTO preverChurn(ClienteRequestDTO clienteDTO) {

        //  Converte dados de entrada para features
        ClienteFeaturesDTO features =
                conversaoDadosService.processarCliente(clienteDTO);

        //  Chama o modelo Python
        PredicaoResponseDTO resultado =
                modeloPythonClient.prever(features);

        //  Persiste o resultado
        Predicao predicao = new Predicao(resultado);
        predicaoRepository.save(predicao);

        //  Retorna resposta para o controller
        return resultado;
    }
}
