package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Log
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @Value("${nome}")
    private String nomeAppProperties;

    @GetMapping("/hello")
    public String hello(){
        log.info("/hello");
        return "Hello world!" + nomeAppProperties;
    }

    @PostMapping
    @Validated
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception{
        PessoaDTO pessoaCriada = pessoaService.create(pessoa);
        log.info("POST REALIZADO");
        return new ResponseEntity<>(pessoaCriada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list() throws Exception {
        List<PessoaDTO> lista = pessoaService.list();
        return new ResponseEntity<>(lista, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idPessoa}")
    public PessoaDTO getById(@PathVariable("idPessoa") Integer id) throws Exception{
        return pessoaService.getById(id);
    }

    @GetMapping("/byname")
    public List<PessoaDTO> getByName(@RequestParam("nome") String nome) throws Exception{
        return pessoaService.getByName(nome);
    }

    @PutMapping("/{idPessoa}")
    @Validated
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        PessoaDTO pessoaDTO = pessoaService.update(id, pessoaAtualizar);
        log.info("PUT REALIZADO");

        return new ResponseEntity<>(pessoaDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        PessoaDTO pessoaDTO = pessoaService.delete(id);
        log.info("DELETE REALIZADO");

        return new ResponseEntity<>(pessoaDTO, HttpStatus.ACCEPTED);
    }

}
