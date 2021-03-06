package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;

    public void delete(Long id) throws Exception {
        enderecoRepository.deleteById(id.intValue());
    }

    public EnderecoEntity create(Integer idPessoa, EnderecoEntity enderecoEntity) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaService.findById(idPessoa);
        enderecoEntity.setPessoas(Set.of(pessoaEntity));
        return enderecoRepository.save(enderecoEntity);
    }

    public EnderecoEntity update(EnderecoEntity enderecoEntity) throws Exception {
        return enderecoRepository.save(enderecoEntity);
    }


    public List<EnderecoEntity> list() {
        return enderecoRepository.findAll();
    }

    public EnderecoEntity findById(Integer idEndereco) throws Exception {
        return enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("endereço não econtrado"));
    }
}
