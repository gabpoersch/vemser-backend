//package com.dbc.pessoaapi.email;
//
//import com.dbc.pessoaapi.dto.PessoaDTO;
//import com.dbc.pessoaapi.repository.PessoaRepository;
//import com.dbc.pessoaapi.service.EmailService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@RunWith(MockitoJUnitRunner.Silent.class)
//public class EveryoneEmailTest {
//
//    @Mock
//    EmailService emailService;
//
//    @Mock
//    PessoaRepository pessoaRepository;
//
//    @Mock
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Test
//    public void mustSendEmail() throws Exception {
//
//        try {
//            pessoaRepository.findAll()
//                    .forEach(usuario -> {
//                        PessoaDTO pessoaDTO = objectMapper.convertValue(usuario, PessoaDTO.class);
//                        emailService.sendEveryone(pessoaDTO);
//                        System.out.println("E-mail promocional enviado!");
//                    });
//        } catch (Exception e) {
//            e.printStackTrace();
//        } verify(emailService,times(1)).sendEveryone(any());
//
//    }
//}
