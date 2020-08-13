package com.techriders.frontservice.controllers;

import com.techriders.frontservice.domains.Product;
import com.techriders.frontservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("products")
    public List<Product> getAllProducts(Model model)
    {
        return productService.findAll();
    }
    @GetMapping("/")
    public String home(){
        return "/index";
    }


    @PostMapping
    public void something(){

    }





}
