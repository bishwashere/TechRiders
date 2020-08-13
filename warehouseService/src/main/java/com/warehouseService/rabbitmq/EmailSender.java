package com.warehouseService.rabbitmq;

import com.warehouseService.rabbitmq.domains.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    public void notifyEmailServiceForOrderStatus(ProductOrder productOrder){
        /// some logic for sending email
    }
}
