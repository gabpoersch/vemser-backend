package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private final ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public ContatoService() {
        this.contatoRepository = new ContatoRepository();
    }

    public Contato create(Contato contato) throws Exception {
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(contato.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));

        return contatoRepository.create(contato);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(contatoAtualizar.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));
        return contatoRepository.update(id , contatoAtualizar);
    }

    public void delete(Integer id)  throws Exception {
        contatoRepository.delete(id);
    }

    public List<Contato> getByIdPessoa(Integer idPessoa) {
        return contatoRepository.getByIdPessoa(idPessoa);
    }
}
