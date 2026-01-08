package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.predicao.dto.PredicaoResponseDTO;
import com.hackathon.churninsight.api.domain.predicao.dto.ListagemPredicaoDTO;
import com.hackathon.churninsight.api.domain.predicao.repository.PredicaoRepository;
import com.hackathon.churninsight.api.service.PredicaoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsável pelas operações
 * relacionadas às previsões de churn.
 */
@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearer-key") // Exige JWT em todos os endpoints deste controller
public class PredicaoController {

    private final PredicaoService predicaoService;
    private final PredicaoRepository predicaoRepository;

    public PredicaoController(
            PredicaoService predicaoService,
            PredicaoRepository predicaoRepository
    ) {
        this.predicaoService = predicaoService;
        this.predicaoRepository = predicaoRepository;
    }

    /**
     * Endpoint responsável por receber os dados do cliente
     * e retornar a previsão de churn com a probabilidade associada.
     *
     * @param clienteDTO dados do cliente para análise
     * @return previsão de churn
     */
    @PostMapping("/predict")
    public PredicaoResponseDTO prever(
            @Valid @RequestBody ClienteRequestDTO clienteDTO
    ) {
        return predicaoService.preverChurn(clienteDTO);
    }

    /**
     * Lista todas as previsões realizadas no sistema.
     * Endpoint paginado, ideal para dashboards e consultas históricas.
     *
     * @param pageable parâmetros de paginação
     * @return página de previsões
     */
    @GetMapping("/consultas")
    public Page<ListagemPredicaoDTO> listar(
            @PageableDefault(size = 15) Pageable pageable
    ) {
        return predicaoRepository
                .findAll(pageable)
                .map(ListagemPredicaoDTO::new);
    }
}
