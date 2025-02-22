package com.example.secondService.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Actuator {

    @Value("${KafkaAddr}")
    public  String kafkaAddr;

    @GetMapping("/test2")
    public String test(){

        return "Service 2 iup kafkaAddr = " + kafkaAddr ;
    }

}
