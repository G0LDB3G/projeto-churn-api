package com.hackathon.churninsight.api.domain.cliente.repository;

import com.hackathon.churninsight.api.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCustomerID(String customerID);

    boolean existsByCustomerID(String customerID);
}