package com.techriders.instorepickupservice.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping(value = "/signin")
    public String login(){
        return "user/loginform";
    }
}
