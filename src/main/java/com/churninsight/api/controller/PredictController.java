package com.churninsight.api.controller;

import com.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import com.churninsight.api.service.PredicaoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/status")
    public String status() {
        return "API funcionando!";
    }
}
