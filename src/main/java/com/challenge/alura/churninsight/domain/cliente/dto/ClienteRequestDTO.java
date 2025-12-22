package com.challenge.alura.churninsight.domain.cliente.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequestDTO {
    // Campos conforme sua especificação de IA
    @NotBlank(message = "gênero é obrigatório")
    private String gender;
    
    @NotBlank(message = "Partner é obrigatório")
    private String partner;
    
    @NotBlank(message = "Dependents é obrigatório")
    private String dependents;
    
    @NotBlank(message = "PhoneService é obrigatório")
    private String phoneService;
    
    @NotBlank(message = "MultipleLines é obrigatório")
    private String multipleLines;
    
    @NotBlank(message = "InternetService é obrigatório")
    private String internetService;
    
    @NotBlank(message = "OnlineSecurity é obrigatório")
    private String onlineSecurity;
    
    @NotBlank(message = "OnlineBackup é obrigatório")
    private String onlineBackup;
    
    @NotBlank(message = "DeviceProtection é obrigatório")
    private String deviceProtection;
    
    @NotBlank(message = "TechSupport é obrigatório")
    private String techSupport;
    
    @NotBlank(message = "StreamingTV é obrigatório")
    private String streamingTV;
    
    @NotBlank(message = "StreamingMovies é obrigatório")
    private String streamingMovies;
    
    @NotBlank(message = "Contract é obrigatório")
    private String contract;
    
    @NotBlank(message = "PaperlessBilling é obrigatório")
    private String paperlessBilling;
    
    @NotBlank(message = "PaymentMethod é obrigatório")
    private String paymentMethod;
}
