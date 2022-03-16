package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PessoaRepository {
    private static final List<Pessoa> listaPessoas = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Maicon", LocalDate.parse("10/10/1990", formatter), "12345678910"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Charles", LocalDate.parse("08/05/1985", formatter), "12345678911"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Marina", LocalDate.parse("30/03/1970", formatter), "12345678912"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Rafael", LocalDate.parse("01/07/1990", formatter), "12345678916"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Ana", LocalDate.parse("01/07/1990", formatter), "12345678917"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Tiago", LocalDate.parse("06/12/1994", formatter), "12345678918"));
    }

    public Pessoa create(Pessoa pessoa) {
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> list() {
        return listaPessoas;
    }

    public Pessoa update(Integer id,Pessoa pessoaAtualizar) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public Pessoa delete(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        listaPessoas.remove(pessoaRecuperada);
        return pessoaRecuperada;
    }

    public List<Pessoa> getByName(String nome) {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }
}
