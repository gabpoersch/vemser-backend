package com.dbc.pessoaapi;

import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.service.EmailService;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
@EnableFeignClients
public class PessoaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaApiApplication.class, args);
	}

}
