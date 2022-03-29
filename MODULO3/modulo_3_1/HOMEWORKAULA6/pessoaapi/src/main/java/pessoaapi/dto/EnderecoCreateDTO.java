package pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {
    private Integer idPessoa;
    @NotEmpty
    private String numero;
    @NotEmpty
    @Size(max = 8)
    private String cep;
}