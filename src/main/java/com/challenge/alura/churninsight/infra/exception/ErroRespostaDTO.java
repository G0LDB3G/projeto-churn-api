package com.challenge.alura.churninsight.infra.exception;

import lombok.Value;
import java.time.LocalDateTime;
import java.util.List;

@Value
public class ErroRespostaDTO {
    LocalDateTime timestamp = LocalDateTime.now();
    Integer status;
    String erro;
    List<String> detalhes;
}