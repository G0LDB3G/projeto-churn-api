package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteResponseDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConversaoDadosService {

    public Map<String, Integer> processarCliente(ClienteRequestDTO dados) {
        Map<String, Integer> resultado = new HashMap<>();
        resultado.put("tenure", 1);
        resultado.put("MonthlyCharges", (int) 25.00);
        resultado.put("TotalCharges", (int) 108.80);
        resultado.put("gender_Male", 1);
        resultado.put("Partner_Yes", 0);
        resultado.put("Dependents_Yes", 0);
        resultado.put("PhoneService_Yes", 1);
        resultado.put("MultipleLines_Yes", 0);
        resultado.put("InternetService_Fiber_optic", 0);
        resultado.put("InternetService_No", 0);
        resultado.put("OnlineSecurity_Yes", 1);
        resultado.put("OnlineBackup_Yes", 0);
        resultado.put("DeviceProtection_Yes", 0);
        resultado.put("TechSupport_Yes", 0);
        resultado.put("StreamingTV_Yes", 0);
        resultado.put("StreamingMovies_Yes", 0);
        resultado.put("Contract_One_year", 0);
        resultado.put("Contract_Two_year", 1);
        resultado.put("PaperlessBilling_Yes", 1);
        resultado.put("PaymentMethod_Credit_card_automatic", 0);
        resultado.put("PaymentMethod_Electronic_check", 1);
        resultado.put("PaymentMethod_Mailed_check", 0);
        return resultado;
    }

    private int converterParaBinario(String valor) {
        if (valor == null) return 0;
        return "Yes".equalsIgnoreCase(valor) || "Male".equalsIgnoreCase(valor) ? 1 : 0;
    }

    private int converterContrato(String valor) {
        if (valor == null) return 0;
        return switch (valor) {
            case "One year" -> 1;
            case "Two year" -> 2;
            default -> 0; // Month-to-month
        };
    }

    private int converterMetodoPagamento(String valor) {
        if (valor == null) return 0;
        return switch (valor) {
            case "Electronic check" -> 1;
            case "Mailed check" -> 2;
            case "Bank transfer (automatic)" -> 3;
            default -> 4; // Credit card
        };
    }
}