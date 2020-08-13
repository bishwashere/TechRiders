package com.techriders.emailService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techriders.emailService.emailservice.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.concurrent.CountDownLatch;

import javax.mail.MessagingException;


@Component
public class Receiver {
	
	@Autowired
    private EmailService emailService;
		
	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String messageJSON) throws JsonMappingException, JsonProcessingException, MessagingException {

        System.out.println("Email sent !!!");
        
        emailService.sendEmail(messageJSON);

		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}