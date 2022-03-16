package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Pessoa {
    private Integer idPessoa;

    @NotBlank
    @NotEmpty
    private String nome;

    @Past
    @NotNull
    private LocalDate dataNascimento;

    @NotEmpty
    @NotNull
    @Size(max = 11, min = 11)
    private String cpf;
}