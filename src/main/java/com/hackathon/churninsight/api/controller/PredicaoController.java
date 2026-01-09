package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.cliente.Cliente;
import com.hackathon.churninsight.api.domain.cliente.ClienteRepository;
import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import com.hackathon.churninsight.api.domain.predicao.Predicao;
import com.hackathon.churninsight.api.domain.predicao.PredicaoRepository;
import com.hackathon.churninsight.api.domain.predicao.PredicaoService;
import com.hackathon.churninsight.api.domain.predicao.dto.DadosPredicaoClienteDTO;
import com.hackathon.churninsight.api.domain.predicao.dto.ListagemPredicaoDTO;
import com.hackathon.churninsight.api.domain.predicao.dto.PredicaoResponseDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearer-key")
public class PredicaoController {
    private final PredicaoService predicaoService;
    private final PredicaoRepository predicaoRepository;
    private final ClienteRepository clienteRepository;

    public PredicaoController(PredicaoService predicaoService,
                              PredicaoRepository predicaoRepository,
                              ClienteRepository clienteRepository) {

        this.predicaoService = predicaoService;
        this.predicaoRepository = predicaoRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/predict")
    @Transactional
    public ResponseEntity<DadosPredicaoClienteDTO> prever(@RequestBody @Valid ClienteRequestDTO request) {
        PredicaoResponseDTO resultado = predicaoService.prever(request);

        Cliente cliente = new Cliente(request);
        clienteRepository.save(cliente);

        Predicao predicao = new Predicao(resultado, cliente);
        predicaoRepository.save(predicao);

        return ResponseEntity.ok(new DadosPredicaoClienteDTO(predicao, cliente));
    }

    @GetMapping("/predict/{id}")
    @Transactional
    public ResponseEntity<DadosPredicaoClienteDTO> preverPorClienteId(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getReferenceById(id);

        ClienteRequestDTO request = new ClienteRequestDTO(cliente);

        PredicaoResponseDTO resultado = predicaoService.prever(request);

        Predicao predicao = new Predicao(resultado, cliente);
        predicaoRepository.save(predicao);

        return ResponseEntity.ok(new DadosPredicaoClienteDTO(predicao, cliente));
    }

    @GetMapping("/consultas")
    public Page<ListagemPredicaoDTO> consultar(@PageableDefault(size = 15) Pageable pageable) {
        return predicaoRepository.findAll(pageable).map(ListagemPredicaoDTO::new);
    }
}
