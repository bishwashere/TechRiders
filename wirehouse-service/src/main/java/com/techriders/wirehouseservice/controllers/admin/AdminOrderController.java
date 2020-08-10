package com.techriders.wirehouseservice.controllers.admin;



import com.techriders.wirehouseservice.configs.OrderStatusEnum;
import com.techriders.wirehouseservice.configs.RoleEnum;
import com.techriders.wirehouseservice.domains.ProductOrder;
import com.techriders.wirehouseservice.services.ProductOrderService;
import com.techriders.wirehouseservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.List;

@RequestMapping({"/admin/account","/seller/account","/buyer/account"})
@Controller
public class AdminOrderController {
    @Autowired
    ProductOrderService productOrderService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = {"order-list"})
    public String getSellerOrders(Model model){
        List<ProductOrder> productOrders= productOrderService.getAll();
        model.addAttribute("productOrders",productOrders);
        return "user/orderForm";
    }

    @RequestMapping(value = {"/order-history"})
    public String getOrderHistory(Model model){
        List<ProductOrder> productOrders= productOrderService.getAll();
        model.addAttribute("productOrders",productOrders);
        return "user/orderHistory";
    }
    @RequestMapping(value = {"","/"})
    public String getOrders(Model model){
       List<ProductOrder> productOrders= productOrderService.getAll();
       model.addAttribute("productOrders",productOrders);
        return "admin/orderForm";
    }
    @PostMapping(value = "/save")

    public String save(@ModelAttribute("order")ProductOrder productOrder, @RequestParam("order-status") String stat, @RequestParam("id")Long id, Model model, HttpSession session){
        productOrderService.get(id).setOrderStatus(OrderStatusEnum.valueOf(stat));

        productOrderService.save(productOrderService.get(id));
        model.addAttribute("productOrders",productOrderService.getAll());
        ProductOrder productOrder1 = productOrderService.get(id);
        session.setAttribute("productOrder1",productOrder1);
        return "admin/orderForm";
    }
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")Long id, Model model){
        productOrderService.deleteById(id);
        model.addAttribute("productOrders",productOrderService.getAll());
        return "admin/orderForm";
    }

    @GetMapping(value = "/edit/{id}")
    public String editOrder(@ModelAttribute("productOrder")ProductOrder productOrder,@PathVariable("id")Long id, Model model){
        model.addAttribute("status", RoleEnum.values());
        return "admin/editOrderForm";
    }

    @RequestMapping(value = {"/history"})
    public String getHistory(Model model){
        List<ProductOrder> productOrders= productOrderService.getAll();
        model.addAttribute("productOrders",productOrders);
        return "admin/history";
    }
    @RequestMapping(value = {"/user/delete/{id}"})
    public String deleteFromUser(@PathVariable("id")Long id, Model model){
        ProductOrder productOrder=productOrderService.get(id);
        if(!(productOrder.getOrderStatus().equals("On the way")||productOrder.getOrderStatus().equals("Delivered"))){
            productOrderService.deleteById(id);
        }
        List<ProductOrder> productOrders= productOrderService.getAll();
        model.addAttribute("productOrders",productOrders);
        return "admin/history";
    }
}
