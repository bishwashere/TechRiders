package com.techriders.frontservice.controllers;

import com.techriders.frontservice.domains.BillingAddress;
import com.techriders.frontservice.domains.FavouriteAddress;
import com.techriders.frontservice.domains.User;
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
@RequestMapping(value = "/account/favourite-addr")
public class FavouriteAddressController {

    @Autowired
    UserService userService;

    @Autowired
    FavouriteAddressService favouriteAddressService;

    @GetMapping(value = {"/",""})
    public String index(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserName(authentication.getName());
        model.addAttribute("addresses",favouriteAddressService.findAllByUser(user));

        return "/favourite_addr_list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("favouriteAddress") FavouriteAddress address) {
        return "/favourite_addr_form";
    }
    @PostMapping(value={"/add"})
    public String addPost(@Valid @ModelAttribute("favouriteAddress") FavouriteAddress favouriteAddress, BindingResult result,RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "/favourite_addr_form";
        }else{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByUserName(authentication.getName());
            favouriteAddress.setUser(user);

            favouriteAddressService.save(favouriteAddress);
            redirectAttributes.addFlashAttribute("success_msg","Address has been saved successfully.");
            return "redirect:/account/favourite-addr";
        }

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {

        model.addAttribute("favouriteAddress",favouriteAddressService.findById(id));

        return "/favourite_addr_form";
    }
    @PostMapping(value={"/edit/{id}"})
    public String editPost(@PathVariable("id") Long id,@Valid @ModelAttribute("favouriteAddress") FavouriteAddress favouriteAddress, BindingResult result, RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            return "/favourite_addr_form";

        }else{
            favouriteAddress.setId(id);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByUserName(authentication.getName());
            favouriteAddress.setUser(user);

            favouriteAddressService.save(favouriteAddress);

            redirectAttributes.addFlashAttribute("success_msg","Address has been saved successfully.");

            return "redirect:/account/favourite-addr";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,RedirectAttributes redirectAttributes) {
        favouriteAddressService.deleteById(id);
        redirectAttributes.addFlashAttribute("success_msg","Address has been deleted successfully.");
        return "redirect:/account/favourite-addr";
    }

    @GetMapping(value = "/get/{id}")
    public @ResponseBody FavouriteAddress get(@PathVariable("id") Long id){
        FavouriteAddress favouriteAddress =  favouriteAddressService.findById(id);
        FavouriteAddress newfavouriteAddress = new FavouriteAddress();
        newfavouriteAddress.setId(favouriteAddress.getId());
        newfavouriteAddress.setAddressL1(favouriteAddress.getAddressL1());
        newfavouriteAddress.setAddressL2(favouriteAddress.getAddressL2());
        newfavouriteAddress.setAddressName(favouriteAddress.getAddressName());
        newfavouriteAddress.setCity(favouriteAddress.getCity());
        newfavouriteAddress.setCountry(favouriteAddress.getCountry());
        newfavouriteAddress.setPhoneNumber(favouriteAddress.getPhoneNumber());
        newfavouriteAddress.setState(favouriteAddress.getState());
        newfavouriteAddress.setZipCode(favouriteAddress.getZipCode());
        return newfavouriteAddress;

    }

}
