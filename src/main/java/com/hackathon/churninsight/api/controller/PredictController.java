package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import com.hackathon.churninsight.api.domain.predicao.dto.ListagemPredicaoDTO;
import com.hackathon.churninsight.api.domain.predicao.repository.PredicaoRepository;
import com.hackathon.churninsight.api.service.PredicaoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.hibernate.mapping.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearer-key")
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

        PredicaoResponseDTO resultado =
                predicaoService.preverChurn(clienteDTO);

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/consultas")
    public Page<ListagemPredicaoDTO> consultas(@PageableDefault(size = 15) Pageable pageable) {
        return predicaoRepository.findAll(pageable).map(ListagemPredicaoDTO::new);
    }

}
