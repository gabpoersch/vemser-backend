package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<EnderecoDTO> listAll() throws RegraDeNegocioException{
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO getByIdEndereco(Integer id) throws RegraDeNegocioException{
        return objectMapper.convertValue(enderecoRepository.getByIdEndereco(id), EnderecoDTO.class);
    }

    public List<EnderecoDTO> listByIdPessoa(Integer id) throws RegraDeNegocioException{
        return enderecoRepository.getByIdPessoa(id).stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException{
        endereco.setIdPessoa(idPessoa);
        if(pessoaRepository.getByName(String.valueOf(endereco.getIdPessoa()))==null){
            throw new RegraDeNegocioException("Essa pessoa não existe");
        }
        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        Endereco enderecoRetorno = enderecoRepository.create(enderecoEntity);
        return objectMapper.convertValue(enderecoRetorno, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAlterado) throws RegraDeNegocioException{
        if(pessoaRepository.getByName(String.valueOf(enderecoAlterado.getIdPessoa()))==null){
            throw new RegraDeNegocioException("Essa pessoa não existe");
        }
        Endereco enderecoEntity = objectMapper.convertValue(enderecoAlterado, Endereco.class);
        Endereco enderecoRetorno = enderecoRepository.update(id,enderecoEntity);
        return objectMapper.convertValue(enderecoRetorno, EnderecoDTO.class);
    }

    public EnderecoDTO delete(Integer id) throws Exception{
        Endereco enderecoRetorno = enderecoRepository.delete(id);
        return objectMapper.convertValue(enderecoRetorno, EnderecoDTO.class);
    }
}