package com.whykafkawhy.kfkproducer.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KfkProducerService {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public KfkProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String topic, String message) {
		for(int i = 0; i < 100; i++)
			kafkaTemplate.send(topic,i+"", i+" "+message);
		System.out.println("Message sent to kafka...");
	}
}
