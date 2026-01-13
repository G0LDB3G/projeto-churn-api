package com.hackathon.churninsight.api.infra.client;

import com.hackathon.churninsight.api.domain.predicao.dto.PredicaoResponseDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Cliente responsável por se comunicar com o modelo de Machine Learning em Python.
 *
 * Essa classe envia os dados do cliente já convertidos
 * e recebe a previsão de churn do modelo.
 */
@Component
public class ModeloPythonClient {

    /**
     * URL da API do Data Science.
     * Deve ser configurada como variável de ambiente.
     * Exemplo:
     * URL_API_DS=http://localhost:8000/predict
     */
    private final String URL_MODELO = System.getenv("URL_API_DS");

    /**
     * Token de autenticação da API Python.
     * Também deve vir das variáveis de ambiente.
     */
    private final String TOKEN = System.getenv("USER_TOKEN");

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Envia os dados convertidos para o modelo de IA
     * e retorna a previsão de churn.
     *
     * @param dadosConvertidos Mapa com os atributos esperados pelo modelo Python
     * @return Resultado da previsão (churn + probabilidade)
     */
    public PredicaoResponseDTO prever(Map<String, Object> dadosConvertidos) {

        // Cabeçalhos da requisição HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Autenticação via Bearer Token
        headers.setBearerAuth(TOKEN);

        // Corpo da requisição + headers
        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(dadosConvertidos, headers);


        // Erro de conexão com o modelo, timeout ou API DS indisponível

        try {
            ResponseEntity<PredicaoResponseDTO> response =
                    restTemplate.exchange(
                            URL_MODELO,
                            HttpMethod.POST,
                            request,
                            PredicaoResponseDTO.class
                    );
            return response.getBody();

        } catch (
                RestClientException ex) {
            throw new RestClientException("Erro ao se conectar ao modelo DS.");
        }

    }

}
