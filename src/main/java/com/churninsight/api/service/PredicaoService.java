package com.churninsight.api.service;

import com.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class PredicaoService {
    // URL da API Python
    private final String url = System.getenv("URL_API_DS");
    private final String token = System.getenv("USER_TOKEN");

    public PredicaoResponseDTO preverChurn(ClienteRequestDTO clienteDTO) {

        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // adiciona o token no cabeçalho Authorization
        headers.add("Authorization", "Bearer " + token);

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
