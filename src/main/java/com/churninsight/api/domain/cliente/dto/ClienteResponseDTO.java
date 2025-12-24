package com.churninsight.api.domain.cliente.dto;

public class ClienteResponseDTO {

    private int gender;
    private int partner;
    private int dependets;
    private int phoneService;
    private int multipleLines;
    private int internetService;
    private int onlineSecurity;
    private int onlineBackup;
    private int deviceProtection;
    private int techSupport;
    private int streamingTv;
    private int streamingMovies;
    private int contract;
    private int paperlessBilling;
    private int paymentMethod;

    public ClienteResponseDTO(int gender, int partner, int dependets, int phoneService, int multipleLines, int internetService, int onlineSecurity, int onlineBackup, int deviceProtection, int techSupport, int streamingTv, int streamingMovies, int contract, int paperlessBilling, int paymentMethod) {
        this.gender = gender;
        this.partner = partner;
        this.dependets = dependets;
        this.phoneService = phoneService;
        this.multipleLines = multipleLines;
        this.internetService = internetService;
        this.onlineSecurity = onlineSecurity;
        this.onlineBackup = onlineBackup;
        this.deviceProtection = deviceProtection;
        this.techSupport = techSupport;
        this.streamingTv = streamingTv;
        this.streamingMovies = streamingMovies;
        this.contract = contract;
        this.paperlessBilling = paperlessBilling;
        this.paymentMethod = paymentMethod;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDependets() {
        return dependets;
    }

    public void setDependets(int dependets) {
        this.dependets = dependets;
    }

    public int getPartner() {
        return partner;
    }

    public void setPartner(int partner) {
        this.partner = partner;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getMultipleLines() {
        return multipleLines;
    }

    public void setMultipleLines(int multipleLines) {
        this.multipleLines = multipleLines;
    }

    public int getPhoneService() {
        return phoneService;
    }

    public void setPhoneService(int phoneService) {
        this.phoneService = phoneService;
    }

    public int getInternetService() {
        return internetService;
    }

    public void setInternetService(int internetService) {
        this.internetService = internetService;
    }

    public int getOnlineBackup() {
        return onlineBackup;
    }

    public void setOnlineBackup(int onlineBackup) {
        this.onlineBackup = onlineBackup;
    }

    public int getOnlineSecurity() {
        return onlineSecurity;
    }

    public void setOnlineSecurity(int onlineSecurity) {
        this.onlineSecurity = onlineSecurity;
    }

    public int getDeviceProtection() {
        return deviceProtection;
    }

    public void setDeviceProtection(int deviceProtection) {
        this.deviceProtection = deviceProtection;
    }

    public int getTechSupport() {
        return techSupport;
    }

    public void setTechSupport(int techSupport) {
        this.techSupport = techSupport;
    }

    public int getStreamingTv() {
        return streamingTv;
    }

    public void setStreamingTv(int streamingTv) {
        this.streamingTv = streamingTv;
    }

    public int getStreamingMovies() {
        return streamingMovies;
    }

    public void setStreamingMovies(int streamingMovies) {
        this.streamingMovies = streamingMovies;
    }

    public int getContract() {
        return contract;
    }

    public void setContract(int contract) {
        this.contract = contract;
    }

    public int getPaperlessBilling() {
        return paperlessBilling;
    }

    public void setPaperlessBilling(int paperlessBilling) {
        this.paperlessBilling = paperlessBilling;
    }
}
