package com.whykafkawhy.kfkproducer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.whykafkawhy.kfkproducer.services.FetchDataFromRemote;
import com.whykafkawhy.kfkproducer.services.KfkProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	private final KfkProducerService kfkProducer;
	
	private final FetchDataFromRemote fetchDataFromRemote;
	
	public KafkaController(KfkProducerService kfkProducerService, FetchDataFromRemote fetchDataFromRemote) {
		this.kfkProducer = kfkProducerService;
		this.fetchDataFromRemote = fetchDataFromRemote;
	}
	@GetMapping("/send")
    public String sendMessage() {
		kfkProducer.sendMessage("sweettooth", fetchDataFromRemote.getResponseFromRemote());
        return "Message sent to Kafka!";
    }

}
