package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.create(pessoaEntity);
        return objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
    }

    public List<PessoaDTO> list() throws RegraDeNegocioException{
        return pessoaRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        Pessoa pessoaAtualizada = pessoaRepository.update(id, pessoaEntity);
        return objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);
    }

    public PessoaDTO delete(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaDeletada = pessoaRepository.delete(id);
        return objectMapper.convertValue(pessoaDeletada, PessoaDTO.class);
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        Pessoa pessoa = (Pessoa) pessoaRepository.getByName(String.valueOf(id));
        return objectMapper.convertValue(pessoa, PessoaDTO.class);
    }

    public List<PessoaDTO> listByName(String nome) throws RegraDeNegocioException {
        return pessoaRepository.getByName(nome)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }
}