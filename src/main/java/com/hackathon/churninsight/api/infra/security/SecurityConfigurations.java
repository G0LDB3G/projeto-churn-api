package com.hackathon.churninsight.api.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Classe responsável pela configuração de segurança da aplicação.
 *
 * Esta configuração define:
 * - Quais endpoints são públicos e quais são protegidos
 * - Política de sessão stateless (JWT)
 * - Inclusão do filtro de autenticação JWT
 * - Tratamento personalizado para erros de autenticação (401)
 *
 * A aplicação não utiliza sessões em memória, pois a autenticação
 * é feita via token JWT enviado em cada requisição.
 */
@Configuration
public class SecurityConfigurations {

    // Filtro responsável por interceptar requisições
    // e validar o token JWT presente no header Authorization
    private final SecurityFilter securityFilter;

    // EntryPoint customizado para retorno de erro 401 em formato JSON
    private final CustomAuthenticationEntryPoint entryPoint;

    public SecurityConfigurations(
            SecurityFilter securityFilter,
            CustomAuthenticationEntryPoint entryPoint
    ) {
        this.securityFilter = securityFilter;
        this.entryPoint = entryPoint;
    }

    /**
     * Define a cadeia de filtros de segurança do Spring Security.
     *
     * Aqui são configurados:
     * - CSRF desabilitado (APIs REST stateless)
     * - Sessão sem estado (STATELESS)
     * - Endpoints públicos e protegidos
     * - Filtro JWT antes do filtro padrão de autenticação
     * - Tratamento de erro de autenticação (401)
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // Desabilita CSRF pois a API não usa cookies nem sessões
                .csrf(csrf -> csrf.disable())

                // Define que a aplicação não mantém estado de sessão
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Define regras de autorização dos endpoints
                .authorizeHttpRequests(auth -> auth
                        // Endpoints públicos (não exigem autenticação)
                        .requestMatchers(
                                "/auth/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()

                        // Qualquer outro endpoint exige autenticação
                        .anyRequest().authenticated()
                )

                // Define o tratamento de erro para requisições não autenticadas
                .exceptionHandling(ex ->
                        ex.authenticationEntryPoint(entryPoint)
                )

                // Adiciona o filtro JWT antes do filtro padrão de login do Spring
                .addFilterBefore(
                        securityFilter,
                        UsernamePasswordAuthenticationFilter.class
                )

                .build();
    }

    /**
     * Expõe o AuthenticationManager como Bean.
     *
     * Ele é utilizado no processo de autenticação
     * (ex: endpoint de login para gerar o token JWT).
     */
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration
    ) throws Exception {
        return configuration.getAuthenticationManager();
    }

    /**
     * Bean responsável por criptografar e validar senhas.
     *
     * Utiliza o algoritmo BCrypt, recomendado por padrão
     * pelo Spring Security.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
