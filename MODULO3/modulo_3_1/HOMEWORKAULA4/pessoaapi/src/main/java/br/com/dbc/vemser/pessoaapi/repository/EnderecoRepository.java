package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static final List<Endereco> listaEnderecos = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, "99001", 11));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, "99002", 22));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 3, "99003", 33));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 4, "99004", 44));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 5, "99005", 55));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 6, "99006", 66));
    }

    public Endereco create(Endereco endereco, Integer idPessoa){
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(idPessoa);
        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list(){
        return listaEnderecos;
    }

    public Endereco update(Integer id, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));
        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));
        listaEnderecos.remove(enderecoRecuperado);
    }

    public List<Endereco> getByIdEndereco(Integer id){
        return listaEnderecos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> getByIdPessoa(Integer idPessoa) {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(idPessoa);
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(pessoa.getIdPessoa()))
                .collect(Collectors.toList());
    }
}