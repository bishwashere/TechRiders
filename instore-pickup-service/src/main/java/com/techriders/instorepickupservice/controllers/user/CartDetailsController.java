package com.techriders.instorepickupservice.controllers.user;


import com.techriders.instorepickupservice.domains.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CartDetailsController {

    @GetMapping("/buyer/cart-details")
    public String cartDetails(HttpSession session, Model model, HttpServletRequest request) {
        HashMap<Long, Product> cartItems = (HashMap<Long, Product>) session.getAttribute("cart_item");

        if (cartItems == null) {
            cartItems = new HashMap<Long, Product>();
        }
        System.out.println("---------------------------------------"+cartItems.size()+"------------------------------");
        List<Product> products = cartItems.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        double grand_total = products.stream().mapToDouble((pro) -> pro.getQty() * pro.getPrice()).sum();
        NumberFormat formatter = new DecimalFormat("#0.00");
        session.setAttribute("grand_total", formatter.format(grand_total));
        session.setAttribute("products", products);

      return("user/cart_details");
    }
}
