package com.warehouseService.rabbitmq.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/administration")
public class DashboardController {

    @GetMapping("")
    public String index(){
        return "index";
    }
}
