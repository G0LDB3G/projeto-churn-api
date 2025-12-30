package com.hackathon.churninsight.api.infra.client;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteFeaturesDTO;
import com.hackathon.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ModeloPythonClient {

    private static final String URL_MODELO = "http://163.176.196.163:8000/predict;";
    private static final String TOKEN = "token-mateus-456";

    private final RestTemplate restTemplate = new RestTemplate();

    public PredicaoResponseDTO prever(ClienteFeaturesDTO dadosConvertidos) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + TOKEN);

        HttpEntity<ClienteFeaturesDTO> request =
                new HttpEntity<>(dadosConvertidos, headers);

        ResponseEntity<PredicaoResponseDTO> response =
                restTemplate.exchange(
                        URL_MODELO,
                        HttpMethod.POST,
                        request,
                        PredicaoResponseDTO.class
                );

        return response.getBody();
    }
}
