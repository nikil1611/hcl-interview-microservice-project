package com.nikil.medical.research.microservicetwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PublishController {

	@Autowired 
	private JmsTemplate jmsTemplate;
	
	@PostMapping("/publishMessage")
	public ResponseEntity<String> publishMessage(@RequestBody String systemMessage){
		try {
			jmsTemplate.convertAndSend("medical-research-queue",systemMessage);
			return new ResponseEntity<>("Sent", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
