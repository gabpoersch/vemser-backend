package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
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
