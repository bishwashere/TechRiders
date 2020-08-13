package rabbitmq;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.warehouseService.rabbitmq.services.*;
import com.warehouseService.rabbitmq.domains.*;

import java.util.concurrent.TimeUnit;


@Component
public class Receiver {
	
	@Autowired
	RabbitMQSender rabbitMQSender;
		
	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) throws JsonMappingException, JsonProcessingException, InterruptedException {

		System.out.println("Received <" + message + ">");

		TimeUnit.SECONDS.sleep(10);

//		OrderedProduct orderedProduct = new OrderedProduct(message);
//		List<OrderedProduct> orderedProducts = new ArrayList<OrderedProduct>();
//		orderedProducts.add(orderedProduct);
//		ProductOrder productOrder = new ProductOrder(message);
//		productOrder.setOrderedProducts(orderedProducts);
//		// Save.........
		
		System.out.println("Sent to e-mail service !!!");
		rabbitMQSender.send(message);
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}