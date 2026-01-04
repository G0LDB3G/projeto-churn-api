package com.hackathon.churninsight.api.infra.exception;

public class ErroValidacaoException extends RuntimeException {
    public ErroValidacaoException(String message) {
        super(message);
    }
}
