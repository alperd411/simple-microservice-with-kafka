package com.example.secondService.consumer;

import com.example.secondService.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer {
    @Autowired
    KafkaProducer kafkaProducer;
    private int counter = 0;
    @KafkaListener(topics = "first-topic", groupId = "1")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
        counter++;
        if (counter == 4) {
            kafkaProducer.sendMessage("That was final message");
            return;
        }

        if (counter >= 5) {
            kafkaProducer.sendMessage("I will not apply anymore");
        }
        kafkaProducer.sendMessage("I received message: " + message);
    }
}