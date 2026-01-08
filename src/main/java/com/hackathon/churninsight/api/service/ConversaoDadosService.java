package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Serviço responsável por converter os dados do cliente
 * para o formato esperado pelo modelo de Machine Learning.
 */
@Service
public class ConversaoDadosService {

    /**
     * Converte o ClienteRequestDTO em um Map de features
     * compatível com o modelo Python.
     */
    public Map<String, Object> processarCliente(ClienteRequestDTO c) {

        Map<String, Object> features = new HashMap<>();

        // ====== CAMPOS NUMÉRICOS ======
        features.put("tenure", c.tenure());
        features.put("MonthlyCharges", c.monthlyCharges());
        features.put("TotalCharges", c.totalCharges());

        // ====== CAMPOS BINÁRIOS ======
        features.put("gender_Male", bin(c.gender().equalsIgnoreCase("Male")));
        features.put("Partner_Yes", bin(c.partner().equalsIgnoreCase("Yes")));
        features.put("Dependents_Yes", bin(c.dependents().equalsIgnoreCase("Yes")));
        features.put("PhoneService_Yes", bin(c.phoneService().equalsIgnoreCase("Yes")));
        features.put("PaperlessBilling_Yes", bin(c.paperlessBilling().equalsIgnoreCase("Yes")));

        // ====== SERVIÇOS ======
        features.put("OnlineSecurity_Yes", bin(c.onlineSecurity().equalsIgnoreCase("Yes")));
        features.put("OnlineBackup_Yes", bin(c.onlineBackup().equalsIgnoreCase("Yes")));
        features.put("DeviceProtection_Yes", bin(c.deviceProtection().equalsIgnoreCase("Yes")));
        features.put("TechSupport_Yes", bin(c.techSupport().equalsIgnoreCase("Yes")));
        features.put("StreamingTV_Yes", bin(c.streamingTV().equalsIgnoreCase("Yes")));
        features.put("StreamingMovies_Yes", bin(c.streamingMovies().equalsIgnoreCase("Yes")));

        // ====== CONTRATO ======
        features.put("Contract_One_year", bin(c.contract().equalsIgnoreCase("One year")));
        features.put("Contract_Two_year", bin(c.contract().equalsIgnoreCase("Two year")));

        // ====== INTERNET ======
        features.put("InternetService_Fiber_optic",
                bin(c.internetService().equalsIgnoreCase("Fiber optic")));
        features.put("InternetService_No",
                bin(c.internetService().equalsIgnoreCase("No")));

        // ====== PAGAMENTO ======
        features.put("PaymentMethod_Electronic_check",
                bin(c.paymentMethod().equalsIgnoreCase("Electronic check")));
        features.put("PaymentMethod_Mailed_check",
                bin(c.paymentMethod().equalsIgnoreCase("Mailed check")));
        features.put("PaymentMethod_Credit_card_automatic",
                bin(c.paymentMethod().equalsIgnoreCase("Credit card (automatic)")));

        return features;
    }

    /**
     * Converte boolean em 0 ou 1
     * (formato esperado pelo modelo)
     */
    private int bin(boolean valor) {
        return valor ? 1 : 0;
    }
}

