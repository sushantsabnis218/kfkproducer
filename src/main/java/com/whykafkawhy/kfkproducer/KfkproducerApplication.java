package com.whykafkawhy.kfkproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KfkproducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KfkproducerApplication.class, args);
	}

}
