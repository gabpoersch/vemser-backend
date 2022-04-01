package com.dbc.pessoaapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PessoaDTOComContatos extends PessoaCreateDTO {
    private Integer idPessoa;
    private List<ContatoDTO> contatos;
}