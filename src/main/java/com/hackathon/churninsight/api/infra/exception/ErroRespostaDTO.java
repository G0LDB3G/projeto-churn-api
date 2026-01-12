package com.hackathon.churninsight.api.infra.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO padrão para respostas de erro da API.
 *
 * Centraliza o formato das mensagens de erro,
 * garantindo consistência e clareza para o cliente.
 */
@Getter
public class ErroRespostaDTO {

    /**
     * Data e hora em que o erro ocorreu.
     */
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();

    /**
     * Código HTTP do erro.
     */
    private final Integer status;

    /**
     * Tipo ou resumo do erro.
     */
    private final String erro;

    /**
     * Lista de detalhes do erro.
     * Pode conter um ou vários itens.
     */
    private final List<String> detalhes;

    /**
     * Construtor para erro com um único detalhe.
     */
    public ErroRespostaDTO(Integer status, String erro, String detalhe) {
        this.status = status;
        this.erro = erro;
        this.detalhes = List.of(detalhe);
    }

    /**
     * Construtor para erro com múltiplos detalhes.
     */
    public ErroRespostaDTO(Integer status, String erro, List<String> detalhes) {
        this.status = status;
        this.erro = erro;
        this.detalhes = detalhes;
    }
}
