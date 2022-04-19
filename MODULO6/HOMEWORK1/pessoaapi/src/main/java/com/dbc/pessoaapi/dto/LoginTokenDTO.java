package com.dbc.pessoaapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginTokenDTO {
    private String login;
    private String token;
}