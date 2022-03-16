package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Log
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<ContatoDTO> list(){
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> getByIdPessoa(@PathVariable("idPessoa") Integer id){
        return contatoService.getByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    @Validated
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        ContatoDTO contatoDTO = contatoService.create(idPessoa, contato);
        log.info("POST REALIZADO");

        return new ResponseEntity<>(contatoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{idContato}")
    @Validated
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id, @Valid @RequestBody ContatoCreateDTO contato) throws Exception {
        ContatoDTO contatoDTO = contatoService.update(id, contato);
        log.info("PUT REALIZADO");

        return new ResponseEntity<>(contatoDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> delete(@PathVariable("idContato") Integer id) throws Exception {
        ContatoDTO contatoDTO = contatoService.delete(id);
        log.info("DELETE REALIZADO");

        return new ResponseEntity<>(contatoDTO, HttpStatus.ACCEPTED);
    }
}
