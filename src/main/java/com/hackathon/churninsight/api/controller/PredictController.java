package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import com.hackathon.churninsight.api.service.PredicaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PredictController {

    private final PredicaoService predicaoService;

    public PredictController(PredicaoService predicaoService) {
        this.predicaoService = predicaoService;
    }

    @PostMapping("/predict")
    public ResponseEntity<PredicaoResponseDTO> prever(
            @Valid @RequestBody ClienteRequestDTO clienteDTO) {

        PredicaoResponseDTO resultado =
                predicaoService.preverChurn(clienteDTO);

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("API funcionando!");
    }
}

