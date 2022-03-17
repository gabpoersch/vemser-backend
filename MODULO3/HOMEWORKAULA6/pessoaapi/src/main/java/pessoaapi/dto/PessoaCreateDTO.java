package pessoaapi.dto;

import lombok.Data;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @NotBlank
    @Size(min = 2, max = 20, message = "Tamanho inválido")
    private String nome;
    @Past
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private String cpf;
    @Email
    private String email;
}