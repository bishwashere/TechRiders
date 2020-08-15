package com.techriders.frontservice.controllers;

import com.techriders.frontservice.domains.BillingAddress;
import com.techriders.frontservice.domains.FavouriteAddress;
import com.techriders.frontservice.domains.User;
import com.techriders.frontservice.helpers.MyHelper;
import com.techriders.frontservice.services.BillingAddressService;
import com.techriders.frontservice.services.FavouriteAddressService;
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
@RequestMapping(value = "/account/address")
public class BillingAddressController {
    @Autowired
    BillingAddressService billingAddressService;

    @Autowired
    UserService userService;

    @Autowired
    FavouriteAddressService favouriteAddressService;

    @GetMapping(value = {"/",""})
    public String billingAddressForm(@ModelAttribute("billingAddress") BillingAddress billingAddr,HttpSession session,Model model,RedirectAttributes redirectAttributes){
        if(session.getAttribute("cart_item") == null){
            redirectAttributes.addFlashAttribute("error_msg","Cart is empty.");
            return "redirect:/account/cart-details";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserName(authentication.getName());

        model.addAttribute("favouriteAddressService",favouriteAddressService.findAllByUser(user));

        return "/billingForm";
    }
    @PostMapping(value = {"/",""})
    public String saveBillingAddress(@ModelAttribute("favouriteAddress") FavouriteAddress favouriteAddress,@Valid @ModelAttribute("billingAddress") BillingAddress billingAddress, BindingResult result,Model model, HttpSession session){
        if(result.hasErrors()){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByUserName(authentication.getName());
            model.addAttribute("favouriteAddressService",favouriteAddressService.findAllByUser(user));
            return "/billingForm";
        }else{

            if(billingAddress.getSaveIntoFavouriteAddr() == true){

                if(billingAddress.getAddr_id()>0){
                    favouriteAddress.setId(billingAddress.getAddr_id());
                    FavouriteAddress favouriteAddress1 = favouriteAddressService.findById(billingAddress.getAddr_id());
                    favouriteAddress.setAddressName(favouriteAddress1.getAddressName());
                }else{
                    favouriteAddress.setAddressName("Address "+MyHelper.getRandomInt());
                }
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                User user = userService.findByUserName(authentication.getName());
                favouriteAddress.setUser(user);

                favouriteAddressService.save(favouriteAddress);
            }

            session.setAttribute("billingAddress", billingAddress);
            
            return "redirect:/account/address/shipping";
        }

    }
}
