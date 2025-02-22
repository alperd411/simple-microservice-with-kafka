package com.example.firstService.controller;

import com.example.firstService.consumer.KafkaConsumer;
import com.example.firstService.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@CrossOrigin()
public class WsController {

    @Autowired
    KafkaProducer kafkaProducer;
    @Autowired
    KafkaConsumer kafkaConsumer;

    ArrayList<String> messages = new ArrayList<>(Arrays.asList("here we go!","message1", "message2",
            "message3", "message4"));
    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/chat")
    public void startCon() throws InterruptedException {
        List<String> recievedMessages = new ArrayList<>();
        for(String message : messages) {
            sendMessage(message);
            messagingTemplate.convertAndSend( "/topic","sending->"+message);
            Thread.sleep(1000);
            // it's safe to consume with while loop cause every message has response
            while (!KafkaConsumer.blockingQueue.isEmpty()){
                String recievedMessage = KafkaConsumer.blockingQueue.poll();
                messagingTemplate.convertAndSend( "/topic","recieved->"
                        +recievedMessage);
                recievedMessages.add(recievedMessage);
            }
        }
    }


    public void sendMessage(String message) throws InterruptedException {

        kafkaProducer.sendMessage(message);
        Thread.sleep(1000);
    }

}
