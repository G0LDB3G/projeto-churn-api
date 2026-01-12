package com.hackathon.churninsight.api.domain.usuario.repository;

import com.hackathon.churninsight.api.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositório JPA responsável pelo acesso
 * aos dados da entidade Usuario.
 *
 * Utiliza Spring Data JPA para evitar
 * implementação manual de queries.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca um usuário pelo login.
     *
     * Usado principalmente no processo
     * de autenticação.
     */
    Optional<Usuario> findByLogin(String login);

    /**
     * Verifica se já existe um usuário
     * com o login informado.
     *
     * Usado no cadastro para garantir unicidade.
     */
    boolean existsByLogin(String login);
}


