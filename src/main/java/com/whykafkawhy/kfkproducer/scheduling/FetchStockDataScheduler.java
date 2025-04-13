package com.whykafkawhy.kfkproducer.scheduling;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.whykafkawhy.kfkproducer.services.FetchDataFromRemote;

@Component
public class FetchStockDataScheduler {
	 
	private final KafkaTemplate<String, String> kfkProducer;
	private static long counter = 0;
	
	public FetchStockDataScheduler(KafkaTemplate<String, String> kfkProducer) {
		this.kfkProducer = kfkProducer;
	}
	@Scheduled(fixedRate = 100)
	public void runTask() {
		kfkProducer.send("sweettooth", Long.toString(counter++)).thenAccept(
				result -> System.out.println("Message produced to Kafka:"+ result.getRecordMetadata().offset())
		).exceptionally( ex ->{
				System.err.println("Message failed : "+ex.getMessage());
				return null;
		});
	}

}
