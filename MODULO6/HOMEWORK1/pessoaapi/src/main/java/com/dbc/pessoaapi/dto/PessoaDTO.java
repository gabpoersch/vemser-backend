package com.dbc.pessoaapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode(callSuper = true)
@Data
public class PessoaDTO extends PessoaCreateDTO {
    private Integer idPessoa;
}