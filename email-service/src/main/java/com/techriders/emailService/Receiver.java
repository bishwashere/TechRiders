package com.techriders.emailService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;


@Component
public class Receiver {
		
	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) throws JsonMappingException, JsonProcessingException {

		System.out.println("Received <" + message + ">");

		// Save.........
        System.out.println("Saved");

		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}