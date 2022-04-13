package com.dbc.kafkachat.controller;

import com.dbc.kafkachat.service.ProducerService;
import com.dbc.kafkachat.userenum.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/kafkachat")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @GetMapping("/send")
    private void sendMessageToUser(@RequestParam String message, @RequestParam List<Users> receiver) throws JsonProcessingException {
        producerService.sendMessage(message, receiver);
    }
}
