package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.usuario.Usuario;
import com.hackathon.churninsight.api.domain.usuario.dto.*;
import com.hackathon.churninsight.api.domain.usuario.repository.UsuarioRepository;
import com.hackathon.churninsight.api.infra.exception.ErroValidacaoException;
import com.hackathon.churninsight.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder;
    private final TokenService tokenService;

    public AutenticacaoController(
            UsuarioRepository usuarioRepository,
            BCryptPasswordEncoder encoder,
            TokenService tokenService
    ) {
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> cadastrar(
            @RequestBody @Valid DadosCadastroUsuarioDTO dto
    ) {

        if (usuarioRepository.existsByLogin(dto.login())) {
            throw new ErroValidacaoException("Este login já está cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setLogin(dto.login());
        usuario.setSenha(encoder.encode(dto.senha()));

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Registro efetuado com sucesso!");
    }


    @PostMapping("/login")
    public ResponseEntity<TokenJWTDTO> login(@RequestBody @Valid DadosAutenticacaoDTO dto) {

        Usuario usuario = usuarioRepository.findByLogin(dto.login())
                .orElseThrow(() -> new SecurityException("Usuário ou senha inválidos"));

        if (!encoder.matches(dto.senha(), usuario.getSenha())) {
            throw new SecurityException("Usuário ou senha inválidos");
        }

        String token = tokenService.gerarToken(usuario);
        return ResponseEntity.ok(new TokenJWTDTO(token));
    }
}

