package com.techriders.frontservice.controllers.user;

import com.techriders.frontservice.domains.BillingAddress;
import com.techriders.frontservice.domains.User;
import com.techriders.frontservice.services.BillingAddressService;
import com.techriders.frontservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/account/address")
public class BillingAddressController {
    @Autowired
    BillingAddressService billingAddressService;
    UserService userService;
    User user;
    @GetMapping(value = {"/",""})
    public String billingAddressForm(@ModelAttribute("billingAddress") BillingAddress billingAddr,HttpSession session,RedirectAttributes redirectAttributes){
        if(session.getAttribute("cart_item") == null){
            redirectAttributes.addFlashAttribute("error_msg","Cart is empty.");
            return "redirect:/account/cart-details";
        }
        return "user/billingForm";
    }
    @PostMapping(value = {"/",""})
    public String saveBillingAddress(@Valid @ModelAttribute("billingAddress") BillingAddress billingAddr, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "user/billingForm";
        }else{
            session.setAttribute("billingAddress", billingAddr);
//            billingAddressService.save(billingAddr);
//        List<BillingAddress> billingAdres = new ArrayList<BillingAddress>();
//        billingAdres.add(billing);
//        user.setBillingAddress(billingAdres);
//        userService.saveBillingAddressByID(billing.getId());
//            redirectAttributes.addFlashAttribute(billingAddr);
            return "redirect:/account/address/shipping";
        }

    }

    @GetMapping(value = {"/billingList"})
    public String billingAddressList(Model model){
        model.addAttribute("allBillingAddress", billingAddressService.getAllBillingAddress());
        return "/user/billingSuccess";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        BillingAddress billing = billingAddressService.findById(id);

        model.addAttribute("billingAddressUpdate", billing);
        return "/user/update_Billing";
    }
    @PostMapping(value={"/edit/update/{id}"})
    public String updateBillingAddress(@PathVariable("id") long id, BillingAddress billing, BindingResult result, Model model){
        if(result.hasErrors()){
            billing.setId(id);
            return "/user/update_Billing";
        }
        billingAddressService.save(billing);
        model.addAttribute("allBillingAddress",billingAddressService.getAllBillingAddress());
        return "/user/billingSuccess";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, BillingAddress billing, Model model) {
        billing = billingAddressService.findById(id);
        billingAddressService.delete(billing);
        model.addAttribute("allBillingAddress", billingAddressService.getAllBillingAddress());
        return "/user/billingSuccess";
    }
}
