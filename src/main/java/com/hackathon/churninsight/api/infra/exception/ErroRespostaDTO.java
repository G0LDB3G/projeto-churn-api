package com.hackathon.churninsight.api.infra.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ErroRespostaDTO {
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final Integer status;
    private final String erro;
    private final List<String> detalhes;

    public ErroRespostaDTO(Integer status, String erro, String detalhe) {
        this.status = status;
        this.erro = erro;
        this.detalhes = List.of(detalhe);
    }

    public ErroRespostaDTO(Integer status, String erro, List<String> detalhes) {
        this.status = status;
        this.erro = erro;
        this.detalhes = detalhes;
    }
}
