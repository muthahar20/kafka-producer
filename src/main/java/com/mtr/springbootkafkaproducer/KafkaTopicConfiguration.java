package com.mtr.springbootkafkaproducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {


    @Bean
    NewTopic javaguidesTopic(){
	        return TopicBuilder.name("javaguides")
	                .build();
	    }

}
