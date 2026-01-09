package com.hackathon.churninsight.api.controller;

import com.hackathon.churninsight.api.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @DeleteMapping("/usuarios/{id}")
    @Transactional
    public ResponseEntity<Void> excluirPorId(@PathVariable Long id) {
        usuarioRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
