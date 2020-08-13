package com.techriders.frontservice.controllers;


import com.techriders.frontservice.domains.BillingAddress;
import com.techriders.frontservice.domains.ShippingAddress;
import com.techriders.frontservice.services.BillingAddressService;
import com.techriders.frontservice.services.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = {"/",""})
    public String shippingAddressForm(@ModelAttribute("shippingAddress") ShippingAddress shippingAddress, HttpSession session, RedirectAttributes redirectAttributes){
        if(session.getAttribute("cart_item") == null){
            redirectAttributes.addFlashAttribute("error_msg","Cart is empty.");
            return "redirect:/account/cart-details";
        }
        return "/shippingForm";
    }
    @PostMapping(value = {"/",""})
    public String saveShippingAddress(@Valid  @ModelAttribute("shippingAddress") ShippingAddress shippingAddress,BindingResult result,HttpSession session, Model model){
        if(result.hasErrors()){
            return "/shippingForm";
        }else if(session.getAttribute("billingAddress")==null){
            return "redirect:/account/address";
        }else{
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
    @GetMapping(value = {"/shippingAddressList"})
    public String shippingAddressList(Model model){
        model.addAttribute("allShippingAddress", shippingAddressService.getAllShippingAddress());
        return "/shippingSuccess";
    }
    @GetMapping("/editShipping/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        ShippingAddress shipping = shippingAddressService.findById(id);

        model.addAttribute("shippingAddressUpdate", shipping);
        return "/update_Shipping";
    }
    @PostMapping(value={"/editShipping/update/{id}"})
    public String updateShippingAddress(@PathVariable("id") long id, ShippingAddress shipping, BindingResult result, Model model){
        if(result.hasErrors()){
            shipping.setId(id);
            return "/update_Shipping";
        }
        shippingAddressService.save(shipping);
        model.addAttribute("allShippingAddress",shippingAddressService.getAllShippingAddress());
        return "/shippingSuccess";
    }
    @GetMapping("/deleteShipping/{id}")
    public String deleteShipping(@PathVariable("id") long id, ShippingAddress shipping, Model model) {
        shipping= shippingAddressService.findById(id);
        shippingAddressService.delete(shipping);
        model.addAttribute("allShippingAddress", shippingAddressService.getAllShippingAddress());
        return "/shippingSuccess";
    }
}
