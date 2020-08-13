package com.techriders.frontservice.controllers;

import com.techriders.frontservice.domains.ProductOrder;
import com.techriders.frontservice.services.ProductOrderService;
import com.techriders.frontservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RequestMapping("/account")
@Controller
public class UserOrderController {
    @Autowired
    ProductOrderService productOrderService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = {"/order-history"})
    public String getOrderHistory(Model model){
        List<ProductOrder> productOrders= productOrderService.getAll();
        model.addAttribute("productOrders",productOrders);
        return "/orderHistory";
    }

    @RequestMapping(value = {"","/order"})
    public String getOrders(Model model, HttpSession session){
       ProductOrder productOrder= (ProductOrder)session.getAttribute("productOrder1");
       model.addAttribute("productOrder",productOrder);
        return "admin/orderForm";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")Long id, Model model){

        return "admin/orderForm";
    }
    @PostMapping(value = "/order")
    public String order(@ModelAttribute("order")ProductOrder order,Model model){

        return "orderHistory";
    }
    @GetMapping(value = "/checkout")
    public String orderForm(Model model){

        return "/orderForm";
    }
    @GetMapping(value = "/edit")
    public String editOrder(Model model){

        return "/orderForm";
    }
}
