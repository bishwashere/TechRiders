package com.techriders.frontservice.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.techriders.frontservice.FrontServiceApplication;

@Service
public class RabbitMQSender {

  private final RabbitTemplate rabbitTemplate;

  public RabbitMQSender(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void send(String message) {	
	System.out.println("Sending message...");
	rabbitTemplate.convertAndSend(FrontServiceApplication.topicExchangeName, "foo.bar.baz", message);
  }

}