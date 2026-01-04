package com.hackathon.churninsight.api.service;


import com.hackathon.churninsight.api.domain.cliente.Cliente;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrar(ClienteRequestDTO dto) {

        if (repository.existsByCustomerID(dto.customerID())) {
            throw new IllegalArgumentException("Cliente já cadastrado com esse customerID");
        }

        Cliente cliente = new Cliente(
                null,
                dto.customerID(),
                dto.gender(),
                dto.seniorCitizen(),
                dto.partner(),
                dto.dependents(),
                dto.tenure(),
                dto.phoneService(),
                dto.multipleLines(),
                dto.internetService(),
                dto.onlineSecurity(),
                dto.onlineBackup(),
                dto.deviceProtection(),
                dto.techSupport(),
                dto.streamingTV(),
                dto.streamingMovies(),
                dto.contract(),
                dto.paperlessBilling(),
                dto.paymentMethod(),
                dto.monthlyCharges(),
                dto.totalCharges()
        );

        return repository.save(cliente);
    }
}
