package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultasController {
    private final PessoaRepository pessoaRepository;

    @GetMapping("/listar-pessoas-sem-endereco")
    public List<PessoaEntity> listarPessoasSemEndereco() throws RegraDeNegocioException {
        return pessoaRepository.findByPessoaSemEndereco();
    }

    @GetMapping("/listar-aniversariantes")
    public List<PessoaEntity> listarAniversariantes() throws RegraDeNegocioException {
        return pessoaRepository.findByAniversariantes();
    }

    @GetMapping("/listar-todas-pessoas")
    public List<PessoaEntity> listarTodas() throws RegraDeNegocioException {
        return pessoaRepository.findAll();
    }
}
