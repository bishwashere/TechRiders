package com.techriders.frontservice.controllers.user;


import com.techriders.frontservice.domains.Product;
import com.techriders.frontservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/account")
//@SessionAttributes(value = "{cart_item,cart_size}")
public class CartControllerRest {
    @Autowired
    ProductService productService;

    HashMap<Long, Product> oldCartItems;

    @RequestMapping(value = "/add-to-cart", produces = "application/json" )
    public Integer addItems(@RequestParam("id") Long id, @RequestParam("qty") Integer qty, HttpSession session, Model model,HttpServletRequest request)
    {

        oldCartItems= (HashMap<Long, Product>) session.getAttribute("cart_item");
        if(oldCartItems == null){
            oldCartItems = new HashMap<Long, Product>();
        }
        Optional<Product> product= Optional.of(productService.findById(id).get());
        System.out.println(product.get().getName());
        if(product.isPresent())
      {
          product.get().setQty(qty);
          oldCartItems.put(id,product.get());

//          model.addAttribute("cart_item",oldCartItems);
          session.setAttribute("cart_item", oldCartItems);

      }
        session.setAttribute("cart_size",oldCartItems.size());
        return oldCartItems.size();
    }

    @RequestMapping(value = "/remove-item", produces = "application/json")

    public Integer removeItem(@RequestParam("id") Long id,HttpSession session,HttpServletRequest req)
    {
        Optional<Product> product= Optional.of(productService.findById(id).get());

        oldCartItems = (HashMap<Long,Product>) req.getSession().getAttribute("cart_item");
        if(oldCartItems == null){
            oldCartItems = new HashMap<Long,Product>();
        }
        if(oldCartItems.containsKey(id)){
            oldCartItems.remove(id);
        }
        oldCartItems = (HashMap<Long,Product>) req.getSession().getAttribute("cart_item");
        session.setAttribute("cart_size",oldCartItems.size());
        return oldCartItems.size();

    }

}
