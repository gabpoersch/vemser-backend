package com.dbc.produtorconsumidor.controller;

import com.dbc.produtorconsumidor.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/enviar")
    private void enviar(String mensagem) {
        producerService.enviarMensagem(mensagem);
    }
}
