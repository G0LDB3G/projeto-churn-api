package com.hackathon.churninsight.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    // 404 - Recurso não encontrado
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErro404() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErroRespostaDTO(404, "Not Found", "O recurso solicitado não foi encontrado no banco de dados."));
    }

    // 400 - Erro de validação de campos (Bean Validation)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErro400(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest()
                .body(new ErroRespostaDTO(400, "Bad Request - Validação", erros));
    }

    // 400 - JSON malformado
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroLeituraJSON(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body(new ErroRespostaDTO(400, "Bad Request", "Corpo da requisição inválido ou ausente."));
    }

    // 422 - Erros de Regra de Negócio (Ex: BusinessException)
    @ExceptionHandler(ErroValidacaoException.class) // Usando sua classe criada anteriormente
    public ResponseEntity<ErroRespostaDTO> tratarErroRegraNegocio(ErroValidacaoException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ErroRespostaDTO(422, "Unprocessable Entity", ex.getMessage()));
    }

    // 401 - Falha de Autenticação (Token)
    // Se você usar o Interceptor que criamos, ele pode lançar uma exceção personalizada aqui
    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroSeguranca(SecurityException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErroRespostaDTO(401, "Unauthorized", ex.getMessage()));
    }

    // 500 - Erro genérico (Fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroRespostaDTO> tratarErro500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErroRespostaDTO(500, "Internal Server Error", "Ocorreu um erro inesperado no servidor: " + ex.getMessage()));
    }
}