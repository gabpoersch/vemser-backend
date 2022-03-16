package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static final List<Contato> listaContatos = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, "51 99991"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, "51 99992"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, "51 99993"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, "51 99994"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 5, "51 99995"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 6, "51 99996"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list(){
        return listaContatos;
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws RegraDeNegocioException {
        Contato contatoCRUD = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        contatoCRUD.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoCRUD.setNumero(contatoAtualizar.getNumero());
        return contatoCRUD;
    }

    public Contato delete(Integer id) throws RegraDeNegocioException {
        Contato contatoCRUD = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        listaContatos.remove(contatoCRUD);
        return contatoCRUD;
    }

    public List<Contato> getByIdPessoa(Integer id) {
        return listaContatos.stream()
                .filter(c -> c.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}