package com.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

	public static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

	@Autowired
	private Producer producer;

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestBody String message) {
		logger.info("Inside publish method" + message);
		this.producer.sendMessage(message);
	}

	@GetMapping(path = "/show")
	public String display() {
		return "Hi!!!!";
	}

}
