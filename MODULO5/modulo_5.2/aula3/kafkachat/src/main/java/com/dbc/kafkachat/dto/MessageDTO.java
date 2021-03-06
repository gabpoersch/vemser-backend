package com.dbc.kafkachat.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MessageDTO {
    private String usuario;
    private String mensagem;
    private LocalDateTime dataCriacao;
}