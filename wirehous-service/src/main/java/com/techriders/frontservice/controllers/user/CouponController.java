package com.techriders.frontservice.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.techriders.frontservice.domains.Coupon;

@Controller
public class CouponController {

    @GetMapping(value = "/coupon")
    public String viewCoupon(@ModelAttribute("couponDets") Coupon coupon, Model model){
        return "user/couponForm";
    }
    @PostMapping(value="/coupon_save")
    public String saveCoupon(@ModelAttribute("coupons")Coupon coupon, Model model){
        return "user/couponDetails";
    }

}
