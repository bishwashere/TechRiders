package rabbitmq;

import com.warehouseService.rabbitmq.domains.ProductOrder;
import com.warehouseService.rabbitmq.services.RabbitMQSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	
	@Autowired
	RabbitMQSender rabbitMQSender;

    public void notifyEmailServiceForOrderStatus(ProductOrder productOrder){
    	rabbitMQSender.send(productOrder.toString());
    }
}
