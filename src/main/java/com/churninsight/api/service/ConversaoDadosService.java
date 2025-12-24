package com.churninsight.api.service;

import com.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.churninsight.api.domain.cliente.dto.ClienteResponseDTO;

public class ConversaoDadosService {

    public ClienteResponseDTO processarCliente(ClienteRequestDTO dados){
        int genderBinary = converterParaBinario(dados.getGender());
        int partnerBinary = converterParaBinario(dados.getPartner());
        int dependetsBinary = converterParaBinario(dados.getDependents());
        int phoneServiceBinary = converterParaBinario(dados.getPhoneService());
        int multipleLinesBinary = converterParaBinario(dados.getMultipleLines());
        int internetServiceBinary = converterParaBinario(dados.getInternetService());
        int onlineSecurityBinary = converterParaBinario(dados.getOnlineSecurity());
        int onlineBackupBinary = converterParaBinario(dados.getOnlineBackup());
        int deviceProtection = converterParaBinario(dados.getDeviceProtection());
        int techSupportBinary = converterParaBinario(dados.getTechSupport());
        int streamingTvBinary = converterParaBinario(dados.getStreamingTv());
        int streamingMoviesBinary = converterParaBinario(dados.getStreamingMovies());
        int contractBinary = converterParaBinario(dados.getContract());
        int paperlessBillingBinary = converterParaBinario(dados.getPaperlessBilling());
        int paymentMethodBinary = converterParaBinario(dados.getPaymentMethod());

        return new ClienteResponseDTO(
                genderBinary,
                partnerBinary,
                dependetsBinary,
                phoneServiceBinary,
                multipleLinesBinary,
                internetServiceBinary,
                onlineSecurityBinary,
                onlineBackupBinary,
                deviceProtection,
                techSupportBinary,
                streamingTvBinary,
                streamingMoviesBinary,
                contractBinary,
                paperlessBillingBinary,
                paymentMethodBinary
                );
    }

    private int converterParaBinario(String valor) {
        if (valor == null) return 0;
        return "Yes".equalsIgnoreCase(valor) ? 1 : 0;
    }

}
