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
 * Define:
 * - Endpoints públicos
 * - Endpoints protegidos
 * - Política de sessão (stateless)
 * - Filtro JWT
 * - Tratamento de erros 401 e 403
 */
@Configuration
public class SecurityConfigurations {

    private final SecurityFilter securityFilter;
//    private final JwtAuthenticationEntryPoint authenticationEntryPoint;
//    private final JwtAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint entryPoint;

    public SecurityConfigurations(
            SecurityFilter securityFilter,
//            JwtAuthenticationEntryPoint authenticationEntryPoint,
//            JwtAccessDeniedHandler accessDeniedHandler,
            CustomAuthenticationEntryPoint entryPoint
    ) {
        this.securityFilter = securityFilter;
//        this.authenticationEntryPoint = authenticationEntryPoint;
//        this.accessDeniedHandler = accessDeniedHandler;
        this.entryPoint = entryPoint;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/auth/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
//                .exceptionHandling(ex -> ex
////                        .authenticationEntryPoint(authenticationEntryPoint)
////                        .accessDeniedHandler(accessDeniedHandler)
//                )

                .exceptionHandling(ex -> ex.authenticationEntryPoint(entryPoint))
                .addFilterBefore(
                        securityFilter,
                        UsernamePasswordAuthenticationFilter.class
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration
    ) throws Exception {
        return configuration.getAuthenticationManager();
    }

    /**
     * Bean responsável por criptografar e validar senhas.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

