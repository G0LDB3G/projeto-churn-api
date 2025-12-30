package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import com.hackathon.churninsight.api.domain.predicao.Predicao;
import com.hackathon.churninsight.api.domain.predicao.repository.PredicaoRepository;
import com.hackathon.churninsight.api.service.PredicaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PredictController {

    private final PredicaoService predicaoService;

    private final PredicaoRepository predicaoRepository;

    public PredictController(PredicaoService predicaoService, PredicaoRepository predicaoRepository) {
        this.predicaoService = predicaoService;
        this.predicaoRepository = predicaoRepository;
    }


    @PostMapping("/predict")
    public ResponseEntity<PredicaoResponseDTO> prever(
            @Valid @RequestBody ClienteRequestDTO clienteDTO) {

        PredicaoResponseDTO resultado = predicaoService.preverChurn(clienteDTO);
        Predicao predicao = new Predicao(resultado);
        predicaoRepository.save(predicao);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("API funcionando!");
    }
}
