package com.hackathon.churninsight.api.service;
import com.hackathon.churninsight.api.domain.predicao.dto.PredicaoResponseDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ModeloPythonClientService {
    private final RestTemplate restTemplate = new RestTemplate();

    private final String URL_MODELO = System.getenv("URL_API_DS");
    private final String PORTA = System.getenv("PORTA");
    private final String TOKEN = System.getenv("USER_TOKEN");

    public PredicaoResponseDTO prever(Map<String, Object> dados) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + TOKEN);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(dados, headers);

        try {
            ResponseEntity<PredicaoResponseDTO> response =
                    restTemplate.exchange(
                            URL_MODELO,
                            HttpMethod.POST,
                            request,
                            PredicaoResponseDTO.class
                    );
            return response.getBody();

        } catch (RestClientException ex) {
            throw new RestClientException("Erro ao se conectar ao modelo DS" + ex);
        }
    }
}
