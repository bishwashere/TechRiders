package com.techriders.logisticservice.controllers.admin;


import com.techriders.logisticservice.domains.User;
import com.techriders.logisticservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping(value = "/administration/users")
public class UserController {




    @Autowired
    UserService userService;

    @GetMapping(value = {"", "/"})
    @PreAuthorize("hasPermission(#id,'user-list')")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/user_list";
    }

    @PostMapping(value = "/accept/{id}")
    public @ResponseBody
    boolean acceptUser(@PathVariable("id") long id) {
        try {
            User user = userService.findById(id);


            return userService.acceptById(id);
        } catch (NoSuchElementException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }

    }
    @PostMapping(value = "/decline/{id}")
    public @ResponseBody
    boolean declinetUser(@PathVariable("id") long id) {
        try {
            User user = userService.findById(id);

            //mail service

            return userService.declinedById(id);
        } catch (NoSuchElementException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }

    }

}
