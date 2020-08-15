package com.warehouseService.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WarehouseServiceApplication {

  public static final String topicExchangeName = "warehouse-exchange";  

  static final String queueNameOrder = "order-queue";
  
  static final String queueNameEmail = "email-queue";

  @Bean
  Queue queue1() {
    return new Queue(queueNameOrder, false);
  }
  
  @Bean
  Queue queue2() {
    return new Queue(queueNameEmail, false);
  }

  @Bean
  TopicExchange exchange() {
    return new TopicExchange(topicExchangeName);
  }

  @Bean
  Binding binding1(@Qualifier("queue1") Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
  }
  
  @Bean
  Binding binding2(@Qualifier("queue2") Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with("email.bar.#");
  }

  @Bean
  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
      MessageListenerAdapter listenerAdapter) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(queueNameOrder);
    container.setMessageListener(listenerAdapter);
    return container;
  }

  @Bean
  MessageListenerAdapter listenerAdapter(Receiver receiver) {
    return new MessageListenerAdapter(receiver, "receiveMessage");
  }

  public static void main(String[] args) {
//    SpringApplication.run(WarehouseServiceApplication.class, args).close();
    SpringApplication.run(WarehouseServiceApplication.class, args);
  }

}