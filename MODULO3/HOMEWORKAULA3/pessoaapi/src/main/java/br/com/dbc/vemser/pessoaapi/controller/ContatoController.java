package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> getByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.getByIdPessoa(idPessoa);
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer idContato, @RequestBody Contato contatoAtualizar) throws Exception  {
        return contatoService.update(idContato, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer idContato) throws Exception  {
        contatoService.delete(idContato);
    }
}