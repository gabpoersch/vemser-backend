package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco create(Endereco endereco, Integer idPessoa) {
        return enderecoRepository.create(endereco, idPessoa);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco update(Integer id, Endereco enderecoAtualizar) throws Exception {
        return enderecoRepository.update(id, enderecoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        enderecoRepository.delete(id);
    }

    public List<Endereco> getByIdEndereco(Integer idEndereco) {
        return enderecoRepository.getByIdEndereco(idEndereco);
    }

    public List<Endereco> getByIdPessoa(Integer idPessoa) {
        return enderecoRepository.getByIdPessoa(idPessoa);
    }

}