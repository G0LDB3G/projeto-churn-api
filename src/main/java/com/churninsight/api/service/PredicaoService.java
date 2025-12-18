package com.churninsight.api.service;

import com.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class PredicaoService {

    public PredicaoResponseDTO preverChurn(ClienteRequestDTO clienteDTO) {

        // URL da API Python
        String url = "http://localhost:8000/predict";

        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ClienteRequestDTO> request = new HttpEntity<>(clienteDTO, headers);

        try {
            ResponseEntity<PredicaoResponseDTO> response =
                    rest.exchange(url, HttpMethod.POST, request, PredicaoResponseDTO.class);

            return response.getBody();

        } catch (Exception e) {
            return new PredicaoResponseDTO("erro", 0.0);
        }
    }
}

