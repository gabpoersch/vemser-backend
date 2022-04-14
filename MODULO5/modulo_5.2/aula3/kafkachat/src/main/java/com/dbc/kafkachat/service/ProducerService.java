package com.dbc.kafkachat.service;

import com.dbc.kafkachat.dto.MessageDTO;
import com.dbc.kafkachat.userenum.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.client-id}")
    private String clientId;

    public void send(String message, Integer ordinal) {
        Message<String> messageBuilder = MessageBuilder.withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, "chat-marcar-churrasco")
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .setHeader(KafkaHeaders.PARTITION_ID, ordinal)
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(messageBuilder);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Erro encontrado!");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Log enviado com sucesso!");
            }
        });
    }

    public void sendMessage(String message, List<Users> receiver) throws JsonProcessingException {
        MessageDTO messageDTO = MessageDTO.builder()
                .usuario(clientId)
                .mensagem(message)
                .dataCriacao(LocalDateTime.now())
                .build();

        String messageDTOasString = objectMapper.writeValueAsString(messageDTO);
        for(Users users:receiver){
            this.send(messageDTOasString, users.ordinal());
        }
    }
}