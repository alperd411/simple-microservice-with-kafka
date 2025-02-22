package com.example.firstService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;



@SpringBootApplication
@EnableWebSocketMessageBroker
@EnableKafka
public class FirstServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstServiceApplication.class, args);


	}

}
