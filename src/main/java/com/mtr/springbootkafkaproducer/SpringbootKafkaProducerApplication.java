package com.mtr.springbootkafkaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class SpringbootKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaProducerApplication.class, args);
	}

}
