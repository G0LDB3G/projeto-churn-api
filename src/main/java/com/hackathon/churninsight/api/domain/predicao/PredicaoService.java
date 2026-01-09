package com.hackathon.churninsight.api.domain.predicao;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.predicao.dto.PredicaoResponseDTO;
import com.hackathon.churninsight.api.service.ConversaoDadosService;
import com.hackathon.churninsight.api.service.ModeloPythonClientService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PredicaoService {
    private final ConversaoDadosService conversaoDadosService;
    private final ModeloPythonClientService modeloPythonClientService;

    public PredicaoService(ConversaoDadosService conversaoDadosService,
                           ModeloPythonClientService modeloPythonClientService) {

        this.conversaoDadosService = conversaoDadosService;
        this.modeloPythonClientService = modeloPythonClientService;
    }

    public PredicaoResponseDTO prever(ClienteRequestDTO request) {
        Map<String, Object> dadosConvertidos = conversaoDadosService.converter(request);

        return modeloPythonClientService.prever(dadosConvertidos);
    }
}
