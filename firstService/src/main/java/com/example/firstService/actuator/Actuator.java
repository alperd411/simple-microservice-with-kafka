package com.example.firstService.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Actuator {

    @Value("${KafkaAddr}")
    public  String kafkaAddr;

    @GetMapping("/test")
    public String test(){

        return "System is up!, kafkaAddr = "+ kafkaAddr;
    }
}
