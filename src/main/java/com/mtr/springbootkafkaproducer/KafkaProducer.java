package com.mtr.springbootkafkaproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);	

	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message){
		logger.info(String.format("Message sent -> %s", message));
        kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
    }
}
