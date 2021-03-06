package pessoaapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pessoaapi.dto.ContatoCreateDTO;
import pessoaapi.dto.ContatoDTO;
import pessoaapi.entity.Contato;
import pessoaapi.exceptions.RegraDeNegocioException;
import pessoaapi.repository.ContatoRepository;
import pessoaapi.repository.PessoaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<ContatoDTO> listarContatos(){
        log.info("Chamou listar contatos");
        return contatoRepository.list().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public void deletarContatos(Integer id) throws Exception {
        log.info("Chamou deletar contatos");
        contatoRepository.delete(id);
    }

    public ContatoDTO criarContato(Integer id, ContatoCreateDTO contatoCriado) throws RegraDeNegocioException {
        if(pessoaRepository.getById(id) == null){
            throw new RegraDeNegocioException("Pessoa não encontrada!");
        }
        log.info("Chamou criar contato");
        Contato contato = objectMapper.convertValue(contatoCriado, Contato.class);
        return objectMapper.convertValue(contatoRepository.create(id, contato), ContatoDTO.class);
    }

    public List<ContatoDTO> getByIdPessoa(Integer id){
        log.info("Chamou achar contato por ID PESSOA");
        return contatoRepository.findContatoByIdPessoa(id).stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO atualizarContato(Integer id, ContatoCreateDTO novoContato) throws Exception {
        if(pessoaRepository.getById(novoContato.getIdPessoa()) == null){
            throw new RegraDeNegocioException("Pessoa não encontrada!");
        }
        log.info("Chamou atualizar contato");
        Contato contato = objectMapper.convertValue(novoContato, Contato.class);
        return objectMapper.convertValue(contatoRepository.update(id, contato), ContatoDTO.class);
    }

    public ContatoDTO findById(Integer id) throws Exception {
        log.info("Chamou achar contato por ID CONTATO");
        return objectMapper.convertValue(contatoRepository.findContatoById(id), ContatoDTO.class);
    }

}
