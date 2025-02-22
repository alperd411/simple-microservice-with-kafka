package com.example.secondService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SecondServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondServiceApplication.class, args);

	}







}
