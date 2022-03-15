package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Endereco create(Endereco endereco, Integer idPessoa) throws Exception {
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(endereco.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));
        return enderecoRepository.create(endereco, idPessoa);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco update(Integer id, Endereco enderecoAtualizar) throws Exception {
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(enderecoAtualizar.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));
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