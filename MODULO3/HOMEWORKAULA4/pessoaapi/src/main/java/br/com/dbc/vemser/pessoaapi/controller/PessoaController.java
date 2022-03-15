package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @Value("${user}")
    private String usuario;


    @GetMapping("/hello")
    public String hello() {
        return "Hello " + usuario;
    }

    @PostMapping
    @Validated
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa)  {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @GetMapping
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname")
    public List<Pessoa> getByName(@RequestParam("nome") String nome) {
        return pessoaService.getByName(nome);
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id, @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}