package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController() {
        contatoService = new ContatoService();
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> getByIdPessoa(@PathVariable("idPessoa") Integer id) {
        return contatoService.getByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    public Contato create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody Contato contato) {
        contato.setIdPessoa(idPessoa);
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id, @RequestBody Contato contato) throws Exception {
        return contatoService.update(id, contato);
    }

    @DeleteMapping("/{idContato}")
    public Contato delete(@PathVariable("idContato") Integer id) throws Exception {
        return contatoService.delete(id);
    }
}
