package com.whykafkawhy.kfkproducer.scheduling;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.whykafkawhy.kfkproducer.services.FetchDataFromRemote;
import com.whykafkawhy.kfkproducer.services.KfkProducerService;

@Component
public class FetchStockDataScheduler {
	 
//	private final KafkaTemplate<String, String> kfkProducer;
	private final KfkProducerService kfkProducerService;
	private static long counter = 0;
	
	public FetchStockDataScheduler(KfkProducerService kfkProducerService) {
		this.kfkProducerService = kfkProducerService;
	}
	@Scheduled(fixedRate = 12000)
	public void runTask() {
		kfkProducerService.sendMessage("sweettooth");
	}

}
