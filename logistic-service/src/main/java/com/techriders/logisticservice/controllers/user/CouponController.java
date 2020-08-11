package com.techriders.logisticservice.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.techriders.logisticservice.domains.Coupon;

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
