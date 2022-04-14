package com.dbc.kafkachat.service;

import com.dbc.kafkachat.dto.MessageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
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
            groupId = "gabriel",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "private",
            topicPartitions = {@TopicPartition(topic = "chat-marcar-churrasco", partitions = {"5"})})
    public void privateConsumer(@Payload String message) throws JsonProcessingException {
        MessageDTO messageDTO = objectMapper.readValue(message, MessageDTO.class);
        System.out.println(messageDTO.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +" ["+messageDTO.getUser()+"](private): "+messageDTO.getMessage());
    }

    @KafkaListener(
            groupId = "gabriel",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "general",
            topicPartitions = {@TopicPartition(topic = "chat-marcar-churrasco", partitions = {"0"})})
    public void generalConsumer(@Payload String message) throws JsonProcessingException {
        MessageDTO messageDTO = objectMapper.readValue(message, MessageDTO.class);

        System.out.println(messageDTO.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +" ["+messageDTO.getUser()+"]: "+messageDTO.getMessage());
    }
}
