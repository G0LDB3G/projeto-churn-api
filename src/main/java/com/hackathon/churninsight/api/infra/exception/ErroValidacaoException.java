package com.hackathon.churninsight.api.infra.exception;

/**
 * Exceção de regra de negócio da aplicação.
 */
public class ErroValidacaoException extends RuntimeException {

    public ErroValidacaoException(String mensagem) {
        super(mensagem);
    }
}
