package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {
    private Integer idPessoa;

    @NotEmpty
    @Size(max=13)
    private String numero;
}
