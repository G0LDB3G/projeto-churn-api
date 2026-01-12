//package com.hackathon.churninsight.api.infra.security;
//
//import com.hackathon.churninsight.api.domain.usuario.repository.UsuarioRepository;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final TokenService tokenService;
//    private final UsuarioRepository usuarioRepository;
//
//    public JwtAuthenticationFilter(
//            TokenService tokenService,
//            UsuarioRepository usuarioRepository
//    ) {
//        this.tokenService = tokenService;
//        this.usuarioRepository = usuarioRepository;
//    }
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain
//    ) throws ServletException, IOException {
//
//        String header = request.getHeader("Authorization");
//
//        if (header != null && header.startsWith("Bearer ")) {
//            String token = header.replace("Bearer ", "");
//
//            String login = tokenService.validarToken(token);
//
//            var usuario = usuarioRepository.findByLogin(login);
//
//            if (usuario.isPresent()) {
//                var authentication = new UsernamePasswordAuthenticationToken(
//                        usuario.get(),
//                        null,
//                        null
//                );
//
//                authentication.setDetails(
//                        new WebAuthenticationDetailsSource().buildDetails(request)
//                );
//
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
//
