package com.warehouseService.rabbitmq.controllers.admin;


import com.warehouseService.rabbitmq.EmailSender;
import com.warehouseService.rabbitmq.configs.OrderStatusEnum;
import com.warehouseService.rabbitmq.configs.RoleEnum;
import com.warehouseService.rabbitmq.domains.ProductOrder;
import com.warehouseService.rabbitmq.services.ProductOrderService;
import com.warehouseService.rabbitmq.services.ProductService;
import javassist.NotFoundException;
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

    @Autowired
    EmailSender emailSender;

    @GetMapping(value ="/order-list/{status}")
    public String getOrdersByStatus(@PathVariable("status") String status, Model model){

        List<ProductOrder> productOrders = productOrderService.findByStatus(status);
        model.addAttribute("productOrders",productOrders);
        model.addAttribute("status",status);
        return "admin/orderList";
    }

    @GetMapping(value ="/change-status/{status}/{id}")
    public String changeOrderStatus(@PathVariable("status") String status,@PathVariable("id") Long id, Model model){
        try {
            ProductOrder productOrder = productOrderService.changeStatus(status,id);
            emailSender.notifyEmailServiceForOrderStatus(productOrder);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/administration/order-management/order-list/"+status;
    }

}
