package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConversaoDadosService {

    public Map<String, Object> converter(ClienteRequestDTO dados) {

        Map<String, Object> dadosConvertidos = new HashMap<>();

        // Numéricos
        dadosConvertidos.put("tenure", dados.tenure());
        dadosConvertidos.put("MonthlyCharges", dados.monthlyCharges());
        dadosConvertidos.put("TotalCharges", dados.totalCharges());

        // Binários
        dadosConvertidos.put("gender_Male", bin(dados.gender().equalsIgnoreCase("Male")));
        dadosConvertidos.put("Partner_Yes", bin(dados.partner().equalsIgnoreCase("Yes")));
        dadosConvertidos.put("Dependents_Yes", bin(dados.dependents().equalsIgnoreCase("Yes")));
        dadosConvertidos.put("PhoneService_Yes", bin(dados.phoneService().equalsIgnoreCase("Yes")));
        dadosConvertidos.put("PaperlessBilling_Yes", bin(dados.paperlessBilling().equalsIgnoreCase("Yes")));

        // Serviços
        dadosConvertidos.put("OnlineSecurity_Yes", bin(dados.onlineSecurity().equalsIgnoreCase("Yes")));
        dadosConvertidos.put("OnlineBackup_Yes", bin(dados.onlineBackup().equalsIgnoreCase("Yes")));
        dadosConvertidos.put("DeviceProtection_Yes", bin(dados.deviceProtection().equalsIgnoreCase("Yes")));
        dadosConvertidos.put("TechSupport_Yes", bin(dados.techSupport().equalsIgnoreCase("Yes")));
        dadosConvertidos.put("StreamingTV_Yes", bin(dados.streamingTV().equalsIgnoreCase("Yes")));
        dadosConvertidos.put("StreamingMovies_Yes", bin(dados.streamingMovies().equalsIgnoreCase("Yes")));

        // Contrato
        dadosConvertidos.put("Contract_One_year", bin(dados.contract().equalsIgnoreCase("One year")));
        dadosConvertidos.put("Contract_Two_year", bin(dados.contract().equalsIgnoreCase("Two year")));

        // Internet
        dadosConvertidos.put("InternetService_Fiber_optic", bin(dados.internetService().equalsIgnoreCase("Fiber optic")));
        dadosConvertidos.put("InternetService_No", bin(dados.internetService().equalsIgnoreCase("No")));

        // Pagamento
        dadosConvertidos.put("PaymentMethod_Electronic_check",
                bin(dados.paymentMethod().equalsIgnoreCase("Electronic check")));
        dadosConvertidos.put("PaymentMethod_Mailed_check",
                bin(dados.paymentMethod().equalsIgnoreCase("Mailed check")));
        dadosConvertidos.put("PaymentMethod_Credit_card_automatic",
                bin(dados.paymentMethod().equalsIgnoreCase("Credit card (automatic)")));

        //System.out.println(dadosConvertidos);
        return dadosConvertidos;
    }

    private int bin(boolean valor) {
        return valor ? 1 : 0;
    }
}
