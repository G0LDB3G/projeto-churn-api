package com.hackathon.churninsight.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.repository.ClienteRepository;
import com.hackathon.churninsight.api.domain.predicao.dto.PredicaoResponseDTO;
import com.hackathon.churninsight.api.domain.predicao.repository.PredicaoRepository;
import com.hackathon.churninsight.api.infra.client.ModeloPythonClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PredicaoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockitoBean
    private ModeloPythonClient pythonClientService; // Simula o modelo de IA
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PredicaoRepository predicaoRepository;

    @BeforeEach
    void setup() {
        predicaoRepository.deleteAll();
        clienteRepository.deleteAll();
    }

    @Test
    @DisplayName("Deve realizar predição, salvar no banco e retornar DTO com previsão")
    @WithMockUser // Assume que o endpoint é protegido
    void preverCenario1() throws Exception {
        // 1. ARRANGE (Dados de entrada)
        var dadosDeEntrada = criarDadosDeEntrada();

        // Simula o retorno que a API Python daria
        var respostaModeloIA = new PredicaoResponseDTO("Vai cancelar",  64.45);

        // Quando o service de Python for chamado, retorna a respostaModeloIA"
        Mockito.when(pythonClientService.prever(Mockito.any())).thenReturn(respostaModeloIA);

        // 2. ACT
        mockMvc.perform(post("/api/predict")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dadosDeEntrada)))

                // 3. ASSERT
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.previsao").value("Vai cancelar"))
                .andExpect(jsonPath("$.probabilidade").value( 64.45));

        // 4. Verifica se cliente e predição foram salvos no bando e dados
        Assertions.assertTrue(clienteRepository.existsByCustomerID("AJHG-4DGZ"));
        Assertions.assertFalse(predicaoRepository.findAll().isEmpty());
    }

    @Test
    @DisplayName("Deve retornar erro 500 quando o serviço do modelo Python falhar")
    @WithMockUser
    void preverCenario2() throws Exception {
        // 1. ARRANGE
        var dadosDeEntrada = criarDadosDeEntrada();

        // Lança uma exceção quando metodo prever de ModeloPythonClientService é chamado
        Mockito.when(pythonClientService.prever(Mockito.anyMap()))
                .thenThrow(new RestClientException("Erro ao se conectar ao modelo DS."));

        // 2. ACT & ASSERT
        mockMvc.perform(post("/api/predict")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dadosDeEntrada)))

                // 3. ASSERT
                .andExpect(status().isInternalServerError()); // Espera erro 500 Internal Server Error

        // 3. ASSERT
        // Verifica se os dados não foram inseridos no banco de dados
        Assertions.assertEquals(0, clienteRepository.count());
    }

    private ClienteRequestDTO criarDadosDeEntrada() {
        return new ClienteRequestDTO(
                "AJHG-4DGZ",
                "Female",
                0,
                "Yes",
                "No",
                10,
                "Yes",
                "No phone service",
                "DSL",
                "No",
                "Yes",
                "No",
                "No",
                "No",
                "No",
                "Month-to-month",
                "Yes",
                "Electronic check",
                BigDecimal.valueOf(29.85),
                BigDecimal.valueOf(29.85)
        );
    }
}
