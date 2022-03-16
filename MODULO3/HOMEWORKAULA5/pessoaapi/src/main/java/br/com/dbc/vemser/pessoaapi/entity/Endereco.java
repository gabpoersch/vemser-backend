package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;

    @NotEmpty
    @Size(max=8)
    private String cep;

    @NotNull
    @Min(0)
    private Integer numero;
}