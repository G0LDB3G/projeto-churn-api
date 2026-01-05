package com.churninsight.api.domain.cliente.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class ClienteRequestDTO {

    //Recebe as propriedades Json do cliente e transforma para Strings;

    @NotNull(message = "genero é obrigatório")
    @JsonProperty("gender_Male")
    private String gender_Male;

    @NotNull(message = "parceiro é obrigatório")
    @JsonProperty("partner")
    private String partner_Yes;

    @NotNull(message = "dependente é obrigatório")
    @JsonProperty("dependents")
    private String dependents_Yes;

    @NotNull(message = "atendimento_telefonico é obrigatório")
    @JsonProperty("phoneService")
    private String phoneService_Yes;

    @NotNull(message = "linhas_multiplas é obrigatório")
    @JsonProperty("multipleLines")
    private String multipleLines_Yes;

    @NotNull(message = "servico_internet é obrigatório")
    @JsonProperty("internetServiceFiberOptic")
    private String internetService_Fiber_Optic;

    @NotNull(message = "servico_internet é obrigatório")
    @JsonProperty("internetService")
    private String internetService_No;

    @NotNull(message = "seguranca_online é obrigatório")
    @JsonProperty("onlineSecurity")
    private String onlineSecurity_Yes;

    @NotNull(message = "backup_online é obrigatório")
    @JsonProperty("onlineBackup")
    private String onlineBackup_Yes;

    @NotNull(message = "protecao_dispositivo é obrigatório")
    @JsonProperty("deviceProtection")
    private String deviceProtection_Yes;

    @NotNull(message = "suporte_tecnico é obrigatório")
    @JsonProperty("techSupport")
    private String techSupport_Yes;

    @NotNull(message = "streaming_tv é obrigatório")
    @JsonProperty("streamingTv")
    private String streamingTv_Yes;

    @NotNull(message = "streaming_filmes é obrigatório")
    @JsonProperty("streamingMovies")
    private String streamingMovies_Yes;

    @NotNull(message = "contrato é obrigatório")
    @JsonProperty("contractOneYear")
    private String contract_One_Year;

    @NotNull(message = "contrato é obrigatório")
    @JsonProperty("contractTwoYear")
    private String contract_Two_Year;

    @NotNull(message = "faturamento é obrigatório")
    @JsonProperty("paperlessBilling")
    private String paperlessBilling_Yes;

    @NotNull(message = "metodo_pagamento é obrigatório")
    @JsonProperty("paymentMethodCreditCardAutomatic")
    private String paymentMethod_Credit_Card_Automatic;

    @NotNull(message = "metodo_pagamento é obrigatório")
    @JsonProperty("paymentMethodElectronicCheck")
    private String paymentMethod_Electronic_Check;

    @NotNull(message = "metodo_pagamento é obrigatório")
    @JsonProperty("paymentMethodMailedCheck")
    private String paymentMethod_Mailed_Check;

    public String getGender_Male() {
        return gender_Male;
    }

    public void setGender_Male(String gender_Male) {
        this.gender_Male = gender_Male;
    }

    public String getPartner_Yes() {
        return partner_Yes;
    }

    public void setPartner_Yes(String partner_Yes) {
        this.partner_Yes = partner_Yes;
    }

    public String getDependents_Yes() {
        return dependents_Yes;
    }

    public void setDependents_Yes(String dependents_Yes) {
        this.dependents_Yes = dependents_Yes;
    }

    public String getPhoneService_Yes() {
        return phoneService_Yes;
    }

    public void setPhoneService_Yes(String phoneService_Yes) {
        this.phoneService_Yes = phoneService_Yes;
    }

    public String getMultipleLines_Yes() {
        return multipleLines_Yes;
    }

    public void setMultipleLines_Yes(String multipleLines_Yes) {
        this.multipleLines_Yes = multipleLines_Yes;
    }

    public String getInternetService_Fiber_Optic() {
        return internetService_Fiber_Optic;
    }

    public void setInternetService_Fiber_Optic(String internetService_Fiber_Optic) {
        this.internetService_Fiber_Optic = internetService_Fiber_Optic;
    }

    public String getOnlineSecurity_Yes() {
        return onlineSecurity_Yes;
    }

    public void setOnlineSecurity_Yes(String onlineSecurity_Yes) {
        this.onlineSecurity_Yes = onlineSecurity_Yes;
    }

    public String getOnlineBackup_Yes() {
        return onlineBackup_Yes;
    }

    public void setOnlineBackup_Yes(String onlineBackup_Yes) {
        this.onlineBackup_Yes = onlineBackup_Yes;
    }

    public String getDeviceProtection_Yes() {
        return deviceProtection_Yes;
    }

    public void setDeviceProtection_Yes(String deviceProtection_Yes) {
        this.deviceProtection_Yes = deviceProtection_Yes;
    }

    public String getTechSupport_Yes() {
        return techSupport_Yes;
    }

    public void setTechSupport_Yes(String techSupport_Yes) {
        this.techSupport_Yes = techSupport_Yes;
    }

    public String getStreamingTv_Yes() {
        return streamingTv_Yes;
    }

    public void setStreamingTv_Yes(String streamingTv_Yes) {
        this.streamingTv_Yes = streamingTv_Yes;
    }

    public String getStreamingMovies_Yes() {
        return streamingMovies_Yes;
    }

    public void setStreamingMovies_Yes(String streamingMovies_Yes) {
        this.streamingMovies_Yes = streamingMovies_Yes;
    }

    public String getContract_One_Year() {
        return contract_One_Year;
    }

    public void setContract_One_Year(String contract_One_Year) {
        this.contract_One_Year = contract_One_Year;
    }

    public String getPaymentMethod_Credit_Card_Automatic() {
        return paymentMethod_Credit_Card_Automatic;
    }

    public void setPaymentMethod_Credit_Card_Automatic(String paymentMethod_Credit_Card_Automatic) {
        this.paymentMethod_Credit_Card_Automatic = paymentMethod_Credit_Card_Automatic;
    }

    public String getPaperlessBilling_Yes() {
        return paperlessBilling_Yes;
    }

    public void setPaperlessBilling_Yes(String paperlessBilling_Yes) {
        this.paperlessBilling_Yes = paperlessBilling_Yes;
    }

    public String getInternetService_No() {
        return internetService_No;
    }

    public void setInternetService_No(String internetService_No) {
        this.internetService_No = internetService_No;
    }

    public String getContract_Two_Year() {
        return contract_Two_Year;
    }

    public void setContract_Two_Year(String contract_Two_Year) {
        this.contract_Two_Year = contract_Two_Year;
    }

    public String getPaymentMethod_Electronic_Check() {
        return paymentMethod_Electronic_Check;
    }

    public void setPaymentMethod_Electronic_Check(String paymentMethod_Electronic_Check) {
        this.paymentMethod_Electronic_Check = paymentMethod_Electronic_Check;
    }

    public String getPaymentMethod_Mailed_Check() {
        return paymentMethod_Mailed_Check;
    }

    public void setPaymentMethod_Mailed_Check(String paymentMethod_Mailed_Check) {
        this.paymentMethod_Mailed_Check = paymentMethod_Mailed_Check;
    }
}
