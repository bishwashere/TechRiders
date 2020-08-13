package com.warehouseService.rabbitmq.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping(value = "/")
    public String login(){
        return "user/loginform";
    }
}
