package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.PessoaDTO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
@Component
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendAddress(PessoaDTO pessoaDTO) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("vakinhavemser@gmail.com");
        simpleMailMessage.setTo(pessoaDTO.getEmail());
        simpleMailMessage.setSubject("ATENÇÃO "+pessoaDTO.getNome()+"!");
        simpleMailMessage.setText("Olá "+pessoaDTO.getNome()+
                "\n\nEstamos muito felizes que você está em nosso sistema." +
                "\nPara que possamos enviá-los um brinde exclusivo, por gentileza, adicione ou atualize o seu endereço no seu cadastro." +
                "\nMuito obrigado,\nSistema de Pessoas");

        javaMailSender.send(simpleMailMessage);
    }

    public void sendEveryone(PessoaDTO pessoaDTO) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("vakinhavemser@gmail.com");
        simpleMailMessage.setTo(pessoaDTO.getEmail());
        simpleMailMessage.setSubject("ATENÇÃO "+pessoaDTO.getNome()+"!");
        simpleMailMessage.setText("Ola "+pessoaDTO.getNome()+"!\n\n" +
                "Selecionamos alguns dos nossos melhores produtos e criamos esta super promoção na nossa plataforma especialmente para você:\n"+
                "- Na compra de um CDs do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico."+"\n"+
                "- Na locação de um filme em VHS, a outra locação é grátis."+"\n" +
                "- Fita de Super Nintendo com 50% de desconto."+"\n\n"+
                "Aproveite,\n"+
                "Magazine OldSchool.");

        javaMailSender.send(simpleMailMessage);
    }

    public void sendBirthday(PessoaDTO pessoaDTO, Integer age) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("vakinhavemser@gmail.com");
        simpleMailMessage.setTo(pessoaDTO.getEmail());
        simpleMailMessage.setSubject("ATENÇÃO "+pessoaDTO.getNome()+"!");
        simpleMailMessage.setText("Olá "+pessoaDTO.getNome()+
                "\n\nEssa data de "+pessoaDTO.getDataNascimento().getDayOfMonth()+"/"+pessoaDTO.getDataNascimento().getMonthValue()+" também é especial para nós do " +
                "Vem Ser. Estamos comemorando junto com você. "+
                "\nDesejamos um feliz aniversário, que sejam "+age+" anos de muitos. Sucesso, alegria, "+
                "felicidade e muitas realizações."+
                "\n\nForte abraço,\n"+
                "#VemSerDBC!");

        javaMailSender.send(simpleMailMessage);
    }

}
