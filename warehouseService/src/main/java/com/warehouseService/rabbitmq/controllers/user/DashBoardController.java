package com.warehouseService.rabbitmq.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/account")
public class DashBoardController {

    @GetMapping(value = {"","/"})
    public String index(){
        return "user/index";
    }


}
