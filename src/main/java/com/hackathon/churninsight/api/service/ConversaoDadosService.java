package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConversaoDadosService {

    public Map<String, Object> processarCliente(ClienteRequestDTO c) {

        Map<String, Object> f = new HashMap<>();

        // Numéricos
        f.put("tenure", c.tenure());
        f.put("MonthlyCharges", c.monthlyCharges());
        f.put("TotalCharges", c.totalCharges());

        // Binários
        f.put("gender_Male", bin(c.gender().equalsIgnoreCase("Male")));
        f.put("Partner_Yes", bin(c.partner().equalsIgnoreCase("Yes")));
        f.put("Dependents_Yes", bin(c.dependents().equalsIgnoreCase("Yes")));
        f.put("PhoneService_Yes", bin(c.phoneService().equalsIgnoreCase("Yes")));
        f.put("PaperlessBilling_Yes", bin(c.paperlessBilling().equalsIgnoreCase("Yes")));

        // Serviços
        f.put("OnlineSecurity_Yes", bin(c.onlineSecurity().equalsIgnoreCase("Yes")));
        f.put("OnlineBackup_Yes", bin(c.onlineBackup().equalsIgnoreCase("Yes")));
        f.put("DeviceProtection_Yes", bin(c.deviceProtection().equalsIgnoreCase("Yes")));
        f.put("TechSupport_Yes", bin(c.techSupport().equalsIgnoreCase("Yes")));
        f.put("StreamingTV_Yes", bin(c.streamingTV().equalsIgnoreCase("Yes")));
        f.put("StreamingMovies_Yes", bin(c.streamingMovies().equalsIgnoreCase("Yes")));

        // Contrato
        f.put("Contract_One_year", bin(c.contract().equalsIgnoreCase("One year")));
        f.put("Contract_Two_year", bin(c.contract().equalsIgnoreCase("Two year")));

        // Internet
        f.put("InternetService_Fiber_optic", bin(c.internetService().equalsIgnoreCase("Fiber optic")));
        f.put("InternetService_No", bin(c.internetService().equalsIgnoreCase("No")));

        // Pagamento
        f.put("PaymentMethod_Electronic_check",
                bin(c.paymentMethod().equalsIgnoreCase("Electronic check")));
        f.put("PaymentMethod_Mailed_check",
                bin(c.paymentMethod().equalsIgnoreCase("Mailed check")));
        f.put("PaymentMethod_Credit_card_automatic",
                bin(c.paymentMethod().equalsIgnoreCase("Credit card (automatic)")));

        System.out.println(f);
        return f;
    }

    private int bin(boolean valor) {
        return valor ? 1 : 0;
    }
}