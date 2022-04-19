package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        contatoService.delete(id);
    }

    @PostMapping("/{idPessoa}")
    public ContatoEntity create(@PathVariable("idPessoa") Integer idPessoa,
                                @RequestBody ContatoEntity contatoEntity) throws Exception {
        return contatoService.create(idPessoa, contatoEntity);
    }

    @PutMapping("/{id}")
    public ContatoEntity update(@PathVariable("id") Integer id,
                                @RequestBody ContatoEntity contatoEntity) throws Exception {
        return contatoService.update(id, contatoEntity);
    }

    @GetMapping
    public List<ContatoEntity> list() {
        return contatoService.list();
    }
}