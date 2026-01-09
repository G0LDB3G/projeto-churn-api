package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.cliente.Cliente;
import com.hackathon.churninsight.api.domain.cliente.ClienteRepository;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.dto.DadosDetalhamentoClienteDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearer-key")
public class ClienteController {
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/clientes")
    @Transactional
    public ResponseEntity<DadosDetalhamentoClienteDTO> cadastrar(@RequestBody @Valid ClienteRequestDTO dados,
                                                                 UriComponentsBuilder uriBuilder) {

        Cliente cliente = new Cliente(dados);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoClienteDTO(cliente));
    }

    @GetMapping("/clientes")
    public Page<DadosDetalhamentoClienteDTO> consultar(@PageableDefault(size = 15) Pageable pageable) {
        return clienteRepository.findAll(pageable).map(DadosDetalhamentoClienteDTO::new);
    }
}
