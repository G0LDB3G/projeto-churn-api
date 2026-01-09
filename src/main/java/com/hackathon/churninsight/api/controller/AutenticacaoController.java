package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.usuario.Usuario;
import com.hackathon.churninsight.api.domain.usuario.UsuarioRepository;
import com.hackathon.churninsight.api.domain.usuario.dto.DadosAutenticacaoUsuarioDTO;
import com.hackathon.churninsight.api.domain.usuario.dto.DadosCadastroUsuarioDTO;
import com.hackathon.churninsight.api.domain.usuario.dto.DadosDetalhamentoUsuarioDTO;
import com.hackathon.churninsight.api.infra.exception.ValidacaoException;
import com.hackathon.churninsight.api.infra.security.DadosTokenJWT;
import com.hackathon.churninsight.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager manager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public AutenticacaoController(UsuarioRepository usuarioRepository,
                                  AuthenticationManager manager,
                                  TokenService tokenService,
                                  PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.manager = manager;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity<DadosDetalhamentoUsuarioDTO> cadastrar(@RequestBody @Valid DadosCadastroUsuarioDTO dados, UriComponentsBuilder uriBuilder) {
        if (usuarioRepository.existsByLogin(dados.login())) {
            throw new ValidacaoException("Usuário com login: " + dados.login() + " já foi cadastrado!");
        }

        Usuario usuario = new Usuario(dados.login(), passwordEncoder.encode(dados.senha()));
        usuarioRepository.save(usuario);

        URI uri = uriBuilder.path("/auth/registrar/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuarioDTO(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<DadosTokenJWT> login(@RequestBody @Valid DadosAutenticacaoUsuarioDTO dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        String tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
