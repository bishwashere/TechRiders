package com.techriders.frontservice.controllers;


import com.techriders.frontservice.domains.BillingAddress;
import com.techriders.frontservice.domains.FavouriteAddress;
import com.techriders.frontservice.domains.ShippingAddress;
import com.techriders.frontservice.domains.User;
import com.techriders.frontservice.helpers.MyHelper;
import com.techriders.frontservice.services.BillingAddressService;
import com.techriders.frontservice.services.FavouriteAddressService;
import com.techriders.frontservice.services.ShippingAddressService;
import com.techriders.frontservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/account/address/shipping")
public class ShippingAddressController {

    @Autowired
    ShippingAddressService shippingAddressService;

    @Autowired
    BillingAddressService billingAddressService;

    @Autowired
    UserService userService;

    @Autowired
    FavouriteAddressService favouriteAddressService;

    @GetMapping(value = {"/",""})
    public String shippingAddressForm(@ModelAttribute("shippingAddress") ShippingAddress shippingAddress, HttpSession session, RedirectAttributes redirectAttributes,Model model){
        if(session.getAttribute("cart_item") == null){
            redirectAttributes.addFlashAttribute("error_msg","Cart is empty.");
            return "redirect:/account/cart-details";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserName(authentication.getName());

        model.addAttribute("favouriteAddressService",favouriteAddressService.findAllByUser(user));
        return "/shippingForm";
    }
    @PostMapping(value = {"/",""})
    public String saveShippingAddress(@ModelAttribute("favouriteAddress") FavouriteAddress favouriteAddress,@Valid  @ModelAttribute("shippingAddress") ShippingAddress shippingAddress, BindingResult result, HttpSession session, Model model){
        if(result.hasErrors()){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByUserName(authentication.getName());

            model.addAttribute("favouriteAddressService",favouriteAddressService.findAllByUser(user));
            return "/shippingForm";
        }else if(session.getAttribute("billingAddress")==null){
            return "redirect:/account/address";
        }else{
            if(shippingAddress.getSaveIntoFavouriteAddr() == true){

                if(shippingAddress.getAddr_id()>0){
                    favouriteAddress.setId(shippingAddress.getAddr_id());
                    FavouriteAddress favouriteAddress1 = favouriteAddressService.findById(shippingAddress.getAddr_id());
                    favouriteAddress.setAddressName(favouriteAddress1.getAddressName());
                }else{
                    favouriteAddress.setAddressName("Address "+MyHelper.getRandomInt());
                }
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                User user = userService.findByUserName(authentication.getName());
                favouriteAddress.setUser(user);

                favouriteAddressService.save(favouriteAddress);
            }
            session.setAttribute("shippingAddress", shippingAddress);

            model.addAttribute("shippingAddress", shippingAddress);

            return "redirect:/account/address/shipping/checkout-success";
        }
    }
    @PostMapping(value = "/get-billing")
    public @ResponseBody BillingAddress getBilling(HttpSession session){
        return (BillingAddress) session.getAttribute("billingAddress");
    }
    @GetMapping(value = {"/checkout-success"})
    public String shippingAddressSuccess(Model model){

        model.addAttribute("allShippingAddress", shippingAddressService.getAllShippingAddress());
        return "redirect:/account/payment_input";
    }
}
