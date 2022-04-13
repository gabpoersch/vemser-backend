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
    @NotEmpty
    @NotNull
    private String user;
    @NotNull
    private String message;
    @NotNull
    private LocalDateTime date;
}