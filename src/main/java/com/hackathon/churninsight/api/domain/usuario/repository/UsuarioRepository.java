package com.hackathon.churninsight.api.domain.usuario.repository;

import com.hackathon.churninsight.api.domain.usuario.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    UserDetails findByLogin(String login);
}
