package com.whykafkawhy.kfkproducer.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KfkProducerService {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	private final FetchDataFromRemote fetchDataFromRemote;
	
	public KfkProducerService(KafkaTemplate<String, String> kafkaTemplate, FetchDataFromRemote fetchDataFromRemote) {
		this.kafkaTemplate = kafkaTemplate;
		this.fetchDataFromRemote = fetchDataFromRemote;
	}
	
	public void sendMessage(String topic) {
		String message = fetchDataFromRemote.getResponseFromRemote();
		kafkaTemplate.send(topic,message).thenAccept(
				result -> System.out.println("Meesage produced to Kafka"+result)
		).exceptionally(
				ex -> {System.out.println("Exception occurred..."+ex.getLocalizedMessage());
					return null;
				}
		);	
	}
}
