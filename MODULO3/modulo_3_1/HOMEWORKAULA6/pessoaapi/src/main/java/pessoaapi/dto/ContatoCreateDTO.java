package pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {
    private Integer idPessoa;
    @NotEmpty
    @Size(min = 5, max = 13)
    private String numero;
}