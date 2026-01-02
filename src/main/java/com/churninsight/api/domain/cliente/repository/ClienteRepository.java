package com.churninsight.api.domain.cliente.repository;

import com.churninsight.api.domain.cliente.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
