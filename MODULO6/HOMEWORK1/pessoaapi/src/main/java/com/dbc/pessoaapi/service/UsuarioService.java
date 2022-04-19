package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.entity.GrupoEntity;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.GrupoRepository;
import com.dbc.pessoaapi.repository.RegraRepository;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final GrupoRepository grupoRepository;
    private final RegraRepository regraRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO cadastro(LoginDTO loginDTO, List<Integer> idRegra) throws RegraDeNegocioException {
        Set<GrupoEntity> hashSet = new HashSet<>();

        for (Integer i : idRegra) {
            hashSet.add(grupoRepository.findById(i).orElseThrow(() -> new RegraDeNegocioException("Grupo inválido")));
        }

        UsuarioEntity novoUsuario = objectMapper.convertValue(loginDTO, UsuarioEntity.class);
        novoUsuario.setGrupos(hashSet);
        novoUsuario.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));
        usuarioRepository.save(novoUsuario);
        return loginDTO;
    }
}
