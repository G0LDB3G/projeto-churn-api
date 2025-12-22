package com.challenge.alura.churninsight.infra.exception;

public class ErroValidacaoException extends RuntimeException {

    public ErroValidacaoException(String mensagem) {
        super(mensagem);
    }
}