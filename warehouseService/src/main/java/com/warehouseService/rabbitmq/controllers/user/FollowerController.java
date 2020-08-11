package com.warehouseService.rabbitmq.controllers.user;

import org.springframework.web.bind.annotation.RequestMapping;

public class FollowerController {

    @RequestMapping("/buyer/followers")
    public String followers(){

        return "user/followers";
    }
    @RequestMapping("/seller/following-list")
    public String followingList(){
        return "user/following_pdf";
    }
}
