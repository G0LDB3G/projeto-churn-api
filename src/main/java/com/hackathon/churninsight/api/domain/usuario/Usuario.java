package com.hackathon.churninsight.api.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidade que representa um usuário do sistema.
 *
 * É utilizada para autenticação e autorização
 * das requisições protegidas.
 */
@Entity
@Table(
        name = "usuarios",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "login")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    /**
     * Identificador único do usuário.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Login do usuário.
     * Deve ser único.
     */
    @Column(nullable = false)
    private String login;

    /**
     * Senha do usuário.
     * Armazenada de forma criptografada (BCrypt).
     */
    @Column(nullable = false)
    private String senha;
}
