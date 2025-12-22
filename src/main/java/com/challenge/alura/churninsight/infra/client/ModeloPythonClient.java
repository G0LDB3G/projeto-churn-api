package com.challenge.alura.churninsight.infra.client;

import com.challenge.alura.churninsight.domain.cliente.dto.ClienteRequestDTO;
import com.challenge.alura.churninsight.domain.cliente.dto.PredicaoResponseDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ModeloPythonClient {

    private final String URL = "http://163.176.196.163:8000/predict";
    private final String TOKEN = "Colocação do token";

    public PredicaoResponseDTO buscarPredicao(ClienteRequestDTO dto) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(TOKEN);

        HttpEntity<ClienteRequestDTO> request = new HttpEntity<>(dto, headers);

        try {
            ResponseEntity<PredicaoResponseDTO> response =
                    rest.exchange(URL, HttpMethod.POST, request, PredicaoResponseDTO.class);
            return response.getBody();
        } catch (Exception e) {
            // No futuro, aqui chamaremos o TratadorDeErros
            throw new RuntimeException("Erro ao conectar com o modelo de IA: " + e.getMessage());
        }
    }
}
