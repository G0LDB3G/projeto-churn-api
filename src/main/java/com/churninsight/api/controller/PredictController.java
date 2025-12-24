package com.churninsight.api.controller;

import com.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.churninsight.api.domain.cliente.dto.ClienteResponseDTO;
import com.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import com.churninsight.api.service.ConversaoDadosService;
import com.churninsight.api.service.PredicaoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PredictController {

    @Autowired
    private PredicaoService predictService;

    @PostMapping("/predict")
    public PredicaoResponseDTO prever(@Valid @RequestBody ClienteRequestDTO clienteDTO) {
        return predictService.preverChurn(clienteDTO);
    }

    @PostMapping("/converter")
    public ResponseEntity<ClienteResponseDTO> handleProcessar(@RequestBody ClienteRequestDTO dados) {

        ConversaoDadosService clienteService = new ConversaoDadosService();
        ClienteResponseDTO resultado = clienteService.processarCliente(dados);

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/status")
    public String status() {
        return "API funcionando!";
    }
}
