package com.mtr.springbootkafkaproducer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class SimpleConsumerTest {

	
	private static final String OFFSET_RESET = "earliest";

    private final KafkaConsumer<String, String> consumer;
    private boolean keepConsuming = true;

    public SimpleConsumerTest(String host, String port, String consumerGroupId, String topic) {
        String server = host + ":" + port;
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OFFSET_RESET);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        this.consumer = new KafkaConsumer<>(properties);
        this.consumer.subscribe(List.of(topic));
    }
    public void consume() {
        while (keepConsuming) {
            final ConsumerRecords<String, String> consumerRecords = this.consumer.poll(Duration.ofMillis(100L));
            if (consumerRecords != null && !consumerRecords.isEmpty()) {
                consumerRecords.iterator().forEachRemaining(consumerRecord -> {
                    System.out.println(consumerRecord.value());
                });
            }
        }
    }

    public static void main(String[] args) {
        SimpleConsumerTest simpleConsumer = new SimpleConsumerTest("localhost", "9092", "transactions-consumer", "transactions");
        simpleConsumer.consume();
    }
	
	
}
