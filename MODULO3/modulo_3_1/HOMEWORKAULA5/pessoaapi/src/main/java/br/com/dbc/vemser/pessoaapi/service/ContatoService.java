package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws RegraDeNegocioException{
        contato.setIdPessoa(idPessoa);
        if(pessoaRepository.getByName(String.valueOf(contato.getIdPessoa()))==null){
            throw new RegraDeNegocioException("Pessoa inexistente");
        }
        Contato contatoEntity = objectMapper.convertValue(contato, Contato.class);
        Contato contatoCriado = contatoRepository.create(contatoEntity);
        return objectMapper.convertValue(contatoCriado, ContatoDTO.class);
    }

    public List<ContatoDTO> list(){
        return contatoRepository.list()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        if(pessoaRepository.getByName(String.valueOf(contatoAtualizar.getIdPessoa()))==null){
            throw new RegraDeNegocioException("Pessoa inexistente");
        }
        Contato contatoEntity = objectMapper.convertValue(contatoAtualizar, Contato.class);
        Contato contatoAtualizado = contatoRepository.update(id, contatoEntity);
        return objectMapper.convertValue(contatoAtualizado, ContatoDTO.class);
    }

    public ContatoDTO delete(Integer id) throws Exception {
        Contato contatoAtualizado = contatoRepository.delete(id);
        return objectMapper.convertValue(contatoAtualizado, ContatoDTO.class);
    }

    public List<ContatoDTO> getByIdPessoa(Integer id){
        return contatoRepository.getByIdPessoa(id)
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }
}