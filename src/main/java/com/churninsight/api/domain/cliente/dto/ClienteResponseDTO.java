package com.churninsight.api.domain.cliente.dto;

public class ClienteResponseDTO {

    //Devolve a resposta ao cliente com as propriedades Json abaixo

    private int gender_Male;
    private int partner_Yes;
    private int dependents_Yes;
    private int phoneService_Yes;
    private int multipleLines_Yes;
    private int internetService_Fiber_Optic;
    private int internetService_No;
    private int onlineSecurity_Yes;
    private int onlineBackup_Yes;
    private int deviceProtection_Yes;
    private int techSupport_Yes;
    private int streamingTv_Yes;
    private int streamingMovies_Yes;
    private int contract_One_Year;
    private int contract_Two_Year;
    private int paperlessBilling_Yes;
    private int paymentMethod_Credit_Card_Automatic;
    private int paymentMethod_Electronic_Check;
    private int paymentMethod_Mailed_Check;

    public ClienteResponseDTO(int gender_Male, int partner_Yes, int dependents_Yes, int phoneService_Yes, int multipleLines_Yes, int internetService_Fiber_Optic, int internetService_No, int onlineSecurity_Yes, int onlineBackup_Yes, int deviceProtection_Yes, int techSupport_Yes, int streamingTv_Yes, int streamingMovies_Yes, int contract_One_Year, int contract_Two_Year, int paperlessBilling_Yes, int paymentMethod_Credit_Card_Automatic, int paymentMethod_Electronic_Check, int paymentMethod_Mailed_Check) {
        this.gender_Male = gender_Male;
        this.partner_Yes = partner_Yes;
        this.dependents_Yes = dependents_Yes;
        this.phoneService_Yes = phoneService_Yes;
        this.multipleLines_Yes = multipleLines_Yes;
        this.internetService_Fiber_Optic = internetService_Fiber_Optic;
        this.internetService_No = internetService_No;
        this.onlineSecurity_Yes = onlineSecurity_Yes;
        this.onlineBackup_Yes = onlineBackup_Yes;
        this.deviceProtection_Yes = deviceProtection_Yes;
        this.techSupport_Yes = techSupport_Yes;
        this.streamingTv_Yes = streamingTv_Yes;
        this.streamingMovies_Yes = streamingMovies_Yes;
        this.contract_One_Year = contract_One_Year;
        this.contract_Two_Year = contract_Two_Year;
        this.paperlessBilling_Yes = paperlessBilling_Yes;
        this.paymentMethod_Credit_Card_Automatic = paymentMethod_Credit_Card_Automatic;
        this.paymentMethod_Electronic_Check = paymentMethod_Electronic_Check;
        this.paymentMethod_Mailed_Check = paymentMethod_Mailed_Check;
    }

    public int getGender_Male() {
        return gender_Male;
    }

    public void setGender_Male(int gender_Male) {
        this.gender_Male = gender_Male;
    }

    public int getDependents_Yes() {
        return dependents_Yes;
    }

    public void setDependents_Yes(int dependents_Yes) {
        this.dependents_Yes = dependents_Yes;
    }

    public int getPartner_Yes() {
        return partner_Yes;
    }

    public void setPartner_Yes(int partner_Yes) {
        this.partner_Yes = partner_Yes;
    }

    public int getPaymentMethod_Credit_Card_Automatic() {
        return paymentMethod_Credit_Card_Automatic;
    }

    public void setPaymentMethod_Credit_Card_Automatic(int paymentMethod_Credit_Card_Automatic) {
        this.paymentMethod_Credit_Card_Automatic = paymentMethod_Credit_Card_Automatic;
    }

    public int getMultipleLines_Yes() {
        return multipleLines_Yes;
    }

    public void setMultipleLines_Yes(int multipleLines_Yes) {
        this.multipleLines_Yes = multipleLines_Yes;
    }

    public int getPhoneService_Yes() {
        return phoneService_Yes;
    }

    public void setPhoneService_Yes(int phoneService_Yes) {
        this.phoneService_Yes = phoneService_Yes;
    }

    public int getInternetService_No() {
        return internetService_No;
    }

    public void setInternetService_No(int internetService_No) {
        this.internetService_No = internetService_No;
    }

    public int getOnlineBackup_Yes() {
        return onlineBackup_Yes;
    }

    public void setOnlineBackup_Yes(int onlineBackup_Yes) {
        this.onlineBackup_Yes = onlineBackup_Yes;
    }

    public int getOnlineSecurity_Yes() {
        return onlineSecurity_Yes;
    }

    public void setOnlineSecurity_Yes(int onlineSecurity_Yes) {
        this.onlineSecurity_Yes = onlineSecurity_Yes;
    }

    public int getDeviceProtection_Yes() {
        return deviceProtection_Yes;
    }

    public void setDeviceProtection_Yes(int deviceProtection_Yes) {
        this.deviceProtection_Yes = deviceProtection_Yes;
    }

    public int getTechSupport_Yes() {
        return techSupport_Yes;
    }

    public void setTechSupport_Yes(int techSupport_Yes) {
        this.techSupport_Yes = techSupport_Yes;
    }

    public int getStreamingTv_Yes() {
        return streamingTv_Yes;
    }

    public void setStreamingTv_Yes(int streamingTv_Yes) {
        this.streamingTv_Yes = streamingTv_Yes;
    }

    public int getStreamingMovies_Yes() {
        return streamingMovies_Yes;
    }

    public void setStreamingMovies_Yes(int streamingMovies_Yes) {
        this.streamingMovies_Yes = streamingMovies_Yes;
    }

    public int getContract_One_Year() {
        return contract_One_Year;
    }

    public void setContract_One_Year(int contract_One_Year) {
        this.contract_One_Year = contract_One_Year;
    }

    public int getPaperlessBilling_Yes() {
        return paperlessBilling_Yes;
    }

    public void setPaperlessBilling_Yes(int paperlessBilling_Yes) {
        this.paperlessBilling_Yes = paperlessBilling_Yes;
    }

    public int getInternetService_Fiber_Optic() {
        return internetService_Fiber_Optic;
    }

    public void setInternetService_Fiber_Optic(int internetService_Fiber_Optic) {
        this.internetService_Fiber_Optic = internetService_Fiber_Optic;
    }

    public int getContract_Two_Year() {
        return contract_Two_Year;
    }

    public void setContract_Two_Year(int contract_Two_Year) {
        this.contract_Two_Year = contract_Two_Year;
    }

    public int getPaymentMethod_Electronic_Check() {
        return paymentMethod_Electronic_Check;
    }

    public void setPaymentMethod_Electronic_Check(int paymentMethod_Electronic_Check) {
        this.paymentMethod_Electronic_Check = paymentMethod_Electronic_Check;
    }

    public int getPaymentMethod_Mailed_Check() {
        return paymentMethod_Mailed_Check;
    }

    public void setPaymentMethod_Mailed_Check(int paymentMethod_Mailed_Check) {
        this.paymentMethod_Mailed_Check = paymentMethod_Mailed_Check;
    }
}
