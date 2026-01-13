package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.cliente.Cliente;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.cliente.repository.ClienteRepository;
import com.hackathon.churninsight.api.domain.predicao.Predicao;
import com.hackathon.churninsight.api.domain.predicao.dto.PredicaoResponseDTO;
import com.hackathon.churninsight.api.domain.predicao.dto.ListagemPredicaoDTO;
import com.hackathon.churninsight.api.domain.predicao.repository.PredicaoRepository;
import com.hackathon.churninsight.api.service.PredicaoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    private final ClienteRepository clienteRepository;

    public PredicaoController(
            PredicaoService predicaoService,
            PredicaoRepository predicaoRepository,
            ClienteRepository clienteRepository
    ) {
        this.predicaoService = predicaoService;
        this.predicaoRepository = predicaoRepository;
        this.clienteRepository = clienteRepository;
    }

    /**
     * Endpoint responsável por receber os dados do cliente
     * e retornar a previsão de churn com a probabilidade associada.
     *
     * @param clienteDTO dados do cliente para análise
     * @return previsão de churn
     */
    @PostMapping("/predict")
    @Transactional
    public ResponseEntity <PredicaoResponseDTO> prever(
            @Valid @RequestBody ClienteRequestDTO clienteDTO
    ) {
        PredicaoResponseDTO resultado = predicaoService.preverChurn(clienteDTO);

        Cliente cliente = new Cliente(clienteDTO);
        clienteRepository.save(cliente);

        Predicao predicao = new Predicao(resultado, cliente);
        predicaoRepository.save(predicao);

        return ResponseEntity.ok(new PredicaoResponseDTO(predicao));
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
            @PageableDefault(size = 100) Pageable pageable
    ) {
        return predicaoRepository
                .findAll(pageable)
                .map(ListagemPredicaoDTO::new);
    }
}
