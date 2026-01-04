package com.churninsight.api.controller;

import com.churninsight.api.domain.ClienteRepository;
import com.churninsight.api.domain.cliente.Cliente;
import com.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.churninsight.api.domain.cliente.dto.ListagemPredicaoDTO;
import com.churninsight.api.domain.cliente.dto.PredicaoResponseDTO;
import com.churninsight.api.domain.predicao.Predicao;
import com.churninsight.api.domain.predicao.repository.PredicaoRepository;
import com.churninsight.api.service.PredicaoService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PredictController {
    private final PredicaoService predictService;
    private final PredicaoRepository predicaoRepository;
    private final ClienteRepository clienteRepository;

    public PredictController(PredicaoService predictService,
                             PredicaoRepository predicaoRepository,
                             ClienteRepository clienteRepository) {

        this.predictService = predictService;
        this.predicaoRepository = predicaoRepository;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/predict")
    public PredicaoResponseDTO prever(@RequestBody @Valid ClienteRequestDTO clienteDTO) {
        PredicaoResponseDTO resultado = predictService.preverChurn(clienteDTO);
        Cliente cliente = new Cliente(clienteDTO);
        Predicao predicao = new Predicao(resultado);

        if (!predicao.getPrevisao().equals("erro")) {
            predicaoRepository.save(predicao);
            clienteRepository.save(cliente);
        }

        return resultado;
    }

    @GetMapping("/predict")
    public Page<ListagemPredicaoDTO> listar(@PageableDefault(size = 15) Pageable pageable) {
        return predicaoRepository.findAll(pageable).map(ListagemPredicaoDTO::new);
    }

    @GetMapping("/status")
    public String status() {
        return "API funcionando!";
    }
}
