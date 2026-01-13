package com.hackathon.churninsight.api.domain.cliente.repository;

import com.hackathon.churninsight.api.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de Cliente
 * Responsável apenas por operações de banco de dados.
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
