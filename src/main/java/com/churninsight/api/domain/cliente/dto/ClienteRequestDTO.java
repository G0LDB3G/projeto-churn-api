package com.churninsight.api.domain.cliente.dto;

import jakarta.validation.constraints.NotNull;

public class ClienteRequestDTO {

    @NotNull(message = "genero é obrigatório")
    private String gender;

    @NotNull(message = "parceiro é obrigatório")
    private String partner;

    @NotNull(message = "dependente é obrigatório")
    private String dependents;

    @NotNull(message = "atendimento_telefonico é obrigatório")
    private String phoneService;

    @NotNull(message = "linhas_multiplas é obrigatório")
    private String multipleLines;

    @NotNull(message = "servico_internet é obrigatório")
    private String internetService;

    @NotNull(message = "seguranca_online é obrigatório")
    private String onlineSecurity;

    @NotNull(message = "backup_online é obrigatório")
    private String onlineBackup;

    @NotNull(message = "protecao_dispositivo é obrigatório")
    private String deviceProtection;

    @NotNull(message = "suporte_tecnico é obrigatório")
    private String techSupport;

    @NotNull(message = "streaming_tv é obrigatório")
    private String streamingTv;

    @NotNull(message = "streaming_filmes é obrigatório")
    private String streamingMovies;

    @NotNull(message = "contrato é obrigatório")
    private String contract;

    @NotNull(message = "faturamento é obrigatório")
    private String paperlessBilling;

    @NotNull(message = "metodo_pagamento é obrigatório")
    private String paymentMethod;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getDependents() {
        return dependents;
    }

    public void setDependents(String dependents) {
        this.dependents = dependents;
    }

    public String getPhoneService() {
        return phoneService;
    }

    public void setPhoneService(String phoneService) {
        this.phoneService = phoneService;
    }

    public String getMultipleLines() {
        return multipleLines;
    }

    public void setMultipleLines(String multipleLines) {
        this.multipleLines = multipleLines;
    }

    public String getInternetService() {
        return internetService;
    }

    public void setInternetService(String internetService) {
        this.internetService = internetService;
    }

    public String getOnlineSecurity() {
        return onlineSecurity;
    }

    public void setOnlineSecurity(String onlineSecurity) {
        this.onlineSecurity = onlineSecurity;
    }

    public String getOnlineBackup() {
        return onlineBackup;
    }

    public void setOnlineBackup(String onlineBackup) {
        this.onlineBackup = onlineBackup;
    }

    public String getDeviceProtection() {
        return deviceProtection;
    }

    public void setDeviceProtection(String deviceProtection) {
        this.deviceProtection = deviceProtection;
    }

    public String getTechSupport() {
        return techSupport;
    }

    public void setTechSupport(String techSupport) {
        this.techSupport = techSupport;
    }

    public String getStreamingTv() {
        return streamingTv;
    }

    public void setStreamingTv(String streamingTv) {
        this.streamingTv = streamingTv;
    }

    public String getStreamingMovies() {
        return streamingMovies;
    }

    public void setStreamingMovies(String streamingMovies) {
        this.streamingMovies = streamingMovies;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaperlessBilling() {
        return paperlessBilling;
    }

    public void setPaperlessBilling(String paperlessBilling) {
        this.paperlessBilling = paperlessBilling;
    }
}
