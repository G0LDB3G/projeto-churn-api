package com.challenge.alura.churninsight.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroRespostaDTO> tratarValidacaoCampos(
            MethodArgumentNotValidException ex) {

        List<String> erros = ex.getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .toList();

        return ResponseEntity.badRequest().body(
                new ErroRespostaDTO(
                        HttpStatus.BAD_REQUEST.value(),
                        "Erro de validação",
                        erros
                )
        );
    }

    @ExceptionHandler(ErroValidacaoException.class)
    public ResponseEntity<ErroRespostaDTO> tratarRegraNegocio(
            ErroValidacaoException ex) {

        return ResponseEntity.unprocessableEntity().body(
                new ErroRespostaDTO(
                        HttpStatus.UNPROCESSABLE_ENTITY.value(),
                        "Erro de regra de negócio",
                        List.of(ex.getMessage())
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroGenerico() {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ErroRespostaDTO(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Erro interno do servidor",
                        List.of("Ocorreu um erro inesperado")
                )
        );
    }

    @ExceptionHandler(org.springframework.web.client.RestClientException.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroApiExterna(org.springframework.web.client.RestClientException ex) {
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(
            new ErroRespostaDTO(
                    HttpStatus.BAD_GATEWAY.value(),
                    "Erro na comunicação com o modelo de IA",
                    List.of("O serviço de predição está temporariamente indisponível.")
            )
    );
 }
}
