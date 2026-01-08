package com.hackathon.churninsight.api.service;

import com.hackathon.churninsight.api.domain.cliente.Cliente;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.repository.ClienteRepository;
import com.hackathon.churninsight.api.infra.exception.ErroValidacaoException;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pelas regras de negócio
 * relacionadas ao cliente.
 */
@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    /**
     * Cadastra um cliente no banco de dados.
     *
     * Regra de negócio:
     * - Não permite cadastrar dois clientes com o mesmo customerId.
     */
    public Cliente cadastrar(ClienteRequestDTO dto) {

        // Verifica se já existe cliente com esse customerId
        if (repository.existsByCustomerID(dto.customerID())) {
            throw new ErroValidacaoException(
                    "Cliente já cadastrado com esse customerID"
            );
        }

        // Converte o DTO em entidade
        Cliente cliente = new Cliente(dto);

        // Salva no banco
        return repository.save(cliente);
    }
}
