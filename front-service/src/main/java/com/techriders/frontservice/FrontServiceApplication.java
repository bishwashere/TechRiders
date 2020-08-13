package com.techriders.frontservice;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FrontServiceApplication {
	
	public static final String topicExchangeName = "order-exchange";
	static final String queueName = "order-queue";
	
	@Bean
	Queue queue() {
	  return new Queue(queueName, false);
	 }
	
	@Bean
	TopicExchange exchange() {
	  return new TopicExchange(topicExchangeName);
	}
	
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
	  return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	}

    public static void main(String[] args) {
        SpringApplication.run(FrontServiceApplication.class, args);
    }
    
    

}
