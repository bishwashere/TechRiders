package com.warehouseService.rabbitmq;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

  private final RabbitTemplate rabbitTemplate;
  private final Receiver receiver;

  public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
    this.receiver = receiver;
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void run(String... args) throws Exception {
	String message = "Hello from RabbitMQ!";
	
	System.out.println("Sending message...");
	rabbitTemplate.convertAndSend(WarehouseServiceApplication.topicExchangeName, "foo.bar.baz", message);
    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
  }

}