package com.example.firstService.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC_NAME= "first-topic";

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        System.out.println("Message " + message +
                " has been sucessfully sent to the topic: " + TOPIC_NAME);
    }
}