package com.hackathon.churninsight.api.controller;


import com.hackathon.churninsight.api.domain.cliente.Cliente;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteResponseDTO;
import com.hackathon.churninsight.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrar(@RequestBody @Valid ClienteRequestDTO dto) {

        Cliente cliente = service.cadastrar(dto);

        return ResponseEntity
                .created(URI.create("/clientes/" + cliente.getId()))
                .body(new ClienteResponseDTO(
                        cliente.getId(),
                        cliente.getCustomerID()
                ));
    }
}
