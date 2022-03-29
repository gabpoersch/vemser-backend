package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private final ContatoRepository contatoRepository;

    public ContatoService() {
        this.contatoRepository = new ContatoRepository();
    }

    public Contato create(Contato contato) {
        return contatoRepository.create(contato);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        return contatoRepository.update(id , contatoAtualizar);
    }

    public Contato delete(Integer id)  throws Exception {
        contatoRepository.delete(id);
        return null;
    }

    public List<Contato> getByIdPessoa(Integer idPessoa) {
        return contatoRepository.getByIdPessoa(idPessoa);
    }
}
