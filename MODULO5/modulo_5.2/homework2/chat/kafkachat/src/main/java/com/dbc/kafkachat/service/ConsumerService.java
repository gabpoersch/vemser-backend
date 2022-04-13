package com.dbc.kafkachat.service;

import com.dbc.kafkachat.dto.MessageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "private")
    public void privateConsumer(@Payload String message,
                                  @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                  @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        MessageDTO messageDTO = objectMapper.readValue(message, MessageDTO.class);

        log.info(messageDTO.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +" ["+messageDTO.getUser()+"]: "+messageDTO.getMessage());
        log.info("#### offset -> '" + offset + "' key -> '" + key + "' -> Consumed Object message -> '" + message + "'");
    }

    @KafkaListener(
            topics = "${kafka.general.topic}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "general")
    public void generalConsumer(@Payload String message,
                               @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                               @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        MessageDTO messageDTO = objectMapper.readValue(message, MessageDTO.class);

        log.info(messageDTO.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +" ["+messageDTO.getUser()+"]: "+messageDTO.getMessage());
        log.info("#### offset -> '" + offset + "' key -> '" + key + "' -> Consumed Object message -> '" + message + "'");
    }




}
