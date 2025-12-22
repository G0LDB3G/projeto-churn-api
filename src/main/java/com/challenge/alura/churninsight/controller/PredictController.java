package com.challenge.alura.churninsight.controller;

import com.challenge.alura.churninsight.domain.cliente.dto.ClienteRequestDTO;
import com.challenge.alura.churninsight.domain.cliente.dto.PredicaoResponseDTO;
import com.challenge.alura.churninsight.service.PredicaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor // Cria o construtor para o PredicaoService automaticamente
public class PredictController {

    private final PredicaoService predictService;

    @PostMapping("/predict")
    public PredicaoResponseDTO prever(@Valid @RequestBody ClienteRequestDTO dto) {
        return predictService.preverChurn(dto);
    }

    @GetMapping("/status")
    public String status() {
        return "API ChurnInsight funcionando!";
    }
}
