package com.hackathon.churninsight.api.infra.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    // 400 - Erro de validação de campos (Bean Validation)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErro400(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest()
                .body(new ErroRespostaDTO(400, "Bad Request - Validação", erros));
    }

    // 401 - Token inválido
    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroToken(JWTVerificationException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErroRespostaDTO(401, "Unauthorized", ex.getMessage()));
    }

    // 404 - Recurso não encontrado
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErro404() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErroRespostaDTO(404, "Not Found", "O recurso solicitado não foi encontrado no banco de dados."));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroMetodoNaoSuportado(HttpRequestMethodNotSupportedException ex) {
        return ResponseEntity.badRequest()
                .body(new ErroRespostaDTO(400, "Bad Request", "O método " + ex.getMethod() + " não é suportado nesse endpoint."));
    }

    // 400 - JSON malformado
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroLeituraJSON() {
        return ResponseEntity.badRequest()
                .body(new ErroRespostaDTO(400, "Bad Request", "Corpo da requisição inválido ou ausente."));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroBadCredentials() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErroRespostaDTO(401, "Unauthorized", "Credenciais inválidas."));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroAuthentication() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErroRespostaDTO(401, "Unauthorized", "Usuário ou senha inválidos."));
    }

    // 401 - Falha de Autenticação (Token)
    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroSeguranca(SecurityException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErroRespostaDTO(401, "Unauthorized", ex.getMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroAcessoNegado() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ErroRespostaDTO(403, "Forbidden", "Acesso negado."));
    }

    // 422 - Erros de Regra de Negócio
    @ExceptionHandler(ValidacaoException.class) // Usando sua classe criada anteriormente
    public ResponseEntity<ErroRespostaDTO> tratarErroRegraNegocio(ValidacaoException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ErroRespostaDTO(422, "Unprocessable Entity", ex.getMessage()));
    }

    // 500 - Erro genérico (Fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroRespostaDTO> tratarErro500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErroRespostaDTO(500, "Internal Server Error", "Ocorreu um erro inesperado no servidor: " + ex.getMessage()));
    }
}
