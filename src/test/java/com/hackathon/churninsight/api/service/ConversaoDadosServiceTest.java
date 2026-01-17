package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

class ConversaoDadosServiceTest {
    private final ConversaoDadosService conversaoService = new ConversaoDadosService();

    @Test
    @DisplayName("Deve converter os dados do cliente para o formato esperado pela IA")
    void conversaoCenario1() {
        // ARRANGE
        var dados = criarDadosDeEntrada();

        // ACT
        Map<String, Object> resultado = conversaoService.processarCliente(dados);

        // ASSERT
        // 1. Campos Numéricos (Devem manter os valores originais)
        Assertions.assertEquals(12, resultado.get("tenure"));
        Assertions.assertEquals(BigDecimal.valueOf(70.0), resultado.get("MonthlyCharges"));
        Assertions.assertEquals(BigDecimal.valueOf(29.85), resultado.get("TotalCharges"));

        // 2. Validação da lógica binária
        // gender_Male deve ser 0 (pois é Female)
        Assertions.assertEquals(0, resultado.get("gender_Male"));

        // Partner_Yes deve ser 1 (pois é Yes)
        Assertions.assertEquals(1, resultado.get("Partner_Yes"));

        // Dependents_Yes deve ser 0 (pois é No)
        Assertions.assertEquals(0, resultado.get("Dependents_Yes"));

        // 3. Validação de Contrato e Internet
        // Contract é "One year", então Contract_One_year deve ser 1 e Contract_Two_year deve ser 0
        Assertions.assertEquals(1, resultado.get("Contract_One_year"));
        Assertions.assertEquals(0, resultado.get("Contract_Two_year"));

        // InternetService é "DSL", então ambos os campos de Fiber e No devem ser 0
        Assertions.assertEquals(0, resultado.get("InternetService_Fiber_optic"));
        Assertions.assertEquals(0, resultado.get("InternetService_No"));

        // 4. Validação de Pagamento
        // É "Electronic check", deve ser 1
        Assertions.assertEquals(1, resultado.get("PaymentMethod_Electronic_check"));
        // Outros devem ser 0
        Assertions.assertEquals(0, resultado.get("PaymentMethod_Mailed_check"));
        Assertions.assertEquals(0, resultado.get("PaymentMethod_Credit_card_automatic"));

        // 5. Validação de Serviços
        Assertions.assertEquals(1, resultado.get("OnlineBackup_Yes")); // Era "Yes"
        Assertions.assertEquals(0, resultado.get("OnlineSecurity_Yes")); // Era "No"
    }

    private ClienteRequestDTO criarDadosDeEntrada() {
        return new ClienteRequestDTO(
                "AJHG-4DGZ",
                "Female",
                0,
                "Yes",
                "No",
                12,
                "Yes",
                "No phone service",
                "DSL",
                "No",
                "Yes",
                "No",
                "No",
                "No",
                "No",
                "One year",
                "Yes",
                "Electronic check",
                BigDecimal.valueOf(70.0),
                BigDecimal.valueOf(29.85)
        );
    }
}
