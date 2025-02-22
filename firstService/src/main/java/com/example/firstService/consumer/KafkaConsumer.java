package com.example.firstService.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@Component
public class KafkaConsumer {
    public String latestMessage = "";
    public static BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(1);

    @KafkaListener(topics = "second-topic", groupId = "2")
    public void consumeMessage(String message) {
        latestMessage = message;
        System.out.println("Received message: " + message);
        if (blockingQueue.isEmpty())
            blockingQueue.add(message);
        else
            return;
    }
}