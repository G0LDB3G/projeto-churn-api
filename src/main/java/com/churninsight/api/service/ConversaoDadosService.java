package com.churninsight.api.service;

import com.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.churninsight.api.domain.cliente.dto.ClienteResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ConversaoDadosService {

    //Pega todos as propriedades da resposta Json do Cliente atribuindo as variáveis e transformando para binarios
    public ClienteResponseDTO processarCliente(ClienteRequestDTO dados){
        int genderBinary = converterParaBinario(dados.getGender_Male());
        int partnerBinary = converterParaBinario(dados.getPartner_Yes());
        int dependentsBinary = converterParaBinario(dados.getDependents_Yes());
        int phoneServiceBinary = converterParaBinario(dados.getPhoneService_Yes());
        int multipleLinesBinary = converterParaBinario(dados.getMultipleLines_Yes());
        int internetServiceFiberOpticBinary = converterParaBinario(dados.getInternetService_Fiber_Optic());
        int internetServiceBinary = converterParaBinario(dados.getInternetService_No());
        int onlineSecurityBinary = converterParaBinario(dados.getOnlineSecurity_Yes());
        int onlineBackupBinary = converterParaBinario(dados.getOnlineBackup_Yes());
        int deviceProtectionBinary = converterParaBinario(dados.getDeviceProtection_Yes());
        int techSupportBinary = converterParaBinario(dados.getTechSupport_Yes());
        int streamingTvBinary = converterParaBinario(dados.getStreamingTv_Yes());
        int streamingMoviesBinary = converterParaBinario(dados.getStreamingMovies_Yes());
        int contractOneYearBinary = converterParaBinario(dados.getContract_One_Year());
        int contractTwoYearBinary = converterParaBinario(dados.getContract_Two_Year());
        int paperlessBillingBinary = converterParaBinario(dados.getPaperlessBilling_Yes());
        int paymentMethodCreditCardBinary = converterParaBinario(dados.getPaymentMethod_Credit_Card_Automatic());
        int paymentMethodElectronicCheckBinary = converterParaBinario(dados.getPaymentMethod_Electronic_Check());
        int paymentMethodMailedCheckBinary = converterParaBinario(dados.getPaymentMethod_Mailed_Check());

        // Retorna novos objetos da resposta do cliente em binario
        return new ClienteResponseDTO(
                genderBinary,
                partnerBinary,
                dependentsBinary,
                phoneServiceBinary,
                multipleLinesBinary,
                internetServiceFiberOpticBinary,
                internetServiceBinary,
                onlineSecurityBinary,
                onlineBackupBinary,
                deviceProtectionBinary,
                techSupportBinary,
                streamingTvBinary,
                streamingMoviesBinary,
                contractOneYearBinary,
                contractTwoYearBinary,
                paperlessBillingBinary,
                paymentMethodCreditCardBinary,
                paymentMethodElectronicCheckBinary,
                paymentMethodMailedCheckBinary
                );
    }

    // Metodo para conversão de Yes ou No para 1 ou 0;
    private int converterParaBinario(String valor) {
        if (valor == null) return 0;
        return "Yes".equalsIgnoreCase(valor) ? 1 : 0;
    }

}
