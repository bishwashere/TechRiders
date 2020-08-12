package com.techriders.frontservice.controllers.user;

import com.techriders.frontservice.configs.RoleEnum;
import com.techriders.frontservice.domains.Authority;
import com.techriders.frontservice.domains.User;
import com.techriders.frontservice.services.AuthorityService;
import com.techriders.frontservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SignUpController {

    @Autowired
    UserService userService;

    @Autowired
    AuthorityService authorityService;

    @GetMapping(value = "/signup")
    public String signupForm(@ModelAttribute("user") User user, Model model){
        model.addAttribute("label","");
        return "user/signup";
    }
    @PostMapping(value = "/signup")
    public String saveBuyer(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("label","");
            model.addAttribute("error_msg","Error Occured.");
            return "user/signup";
        }else{


            Authority authority = authorityService.findByAuthorityId("ROLE_BUYER");

            List<Authority> authorities = new ArrayList<Authority>();
            authorities.add(authority);

            user.setAuthorities(authorities);

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            userService.save(user);

            redirectAttributes.addFlashAttribute("success_msg","Your account has been registered successfully. We will inform you in 24 hours.");
            return "redirect:/signup";
        }

    }
}
