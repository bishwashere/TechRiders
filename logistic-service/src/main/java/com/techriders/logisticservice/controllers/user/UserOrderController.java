package com.techriders.logisticservice.controllers.user;

import com.techriders.logisticservice.domains.ProductOrder;
import com.techriders.logisticservice.services.ProductOrderService;
import com.techriders.logisticservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RequestMapping("/buyer/account")
@Controller
public class UserOrderController {
    @Autowired
    ProductOrderService productOrderService;
    @Autowired
    ProductService productService;

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

        return "user/orderForm";
    }
    @GetMapping(value = "/edit")
    public String editOrder(Model model){

        return "user/orderForm";
    }
}
