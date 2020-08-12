package com.warehouseService.rabbitmq.controllers.admin;


import com.warehouseService.rabbitmq.configs.OrderStatusEnum;
import com.warehouseService.rabbitmq.configs.RoleEnum;
import com.warehouseService.rabbitmq.domains.ProductOrder;
import com.warehouseService.rabbitmq.services.ProductOrderService;
import com.warehouseService.rabbitmq.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/administration/order-management")
@Controller
public class AdminOrderController {
    @Autowired
    ProductOrderService productOrderService;
    @Autowired
    ProductService productService;

//    @RequestMapping(value ="/order-list/{status}", method = RequestMethod.GET)
//    public String getOrdersByStatus(@PathVariable("status") String status, Model model){
//        return ""
//    }
}
