package com.techriders.wirehouseservice.controllers.admin;


import com.techriders.wirehouseservice.domains.User;
import com.techriders.wirehouseservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping(value = "/administration/users")
public class UserController {

    @Autowired
    JavaMailSender javaMailSender;



    @Autowired
    UserService userService;

    @GetMapping(value = {"", "/"})
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/user_list";
    }

    @PostMapping(value = "/accept/{id}")
    public @ResponseBody
    boolean acceptUser(@PathVariable("id") long id) {
        try {
            User user = userService.findById(id);

            SimpleMailMessage mail = new SimpleMailMessage();

            mail.setFrom("TechRiders");
            mail.setTo(user.getEmail());
            mail.setSubject("Account Activated");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Hi ");
            stringBuffer.append(user.getFirstName());
            stringBuffer.append(",");
            stringBuffer.append("\n");
            stringBuffer.append("Your account is activated in TechRiders.\n");
            stringBuffer.append("Now you can login with your username and password.");
            stringBuffer.append("\nThank you.\n");
            stringBuffer.append("TechRiders Team");

            mail.setText(stringBuffer.toString());
            javaMailSender.send(mail);

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
            SimpleMailMessage mail = new SimpleMailMessage();

            User user = userService.findById(id);

            mail.setFrom("TechRiders");
            mail.setTo(user.getEmail());
            mail.setSubject("Account has been deactivated");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Hi ");
            stringBuffer.append(user.getFirstName());
            stringBuffer.append(",");
            stringBuffer.append("\n");
            stringBuffer.append("Your account is deactivated in TechRiders.\n");
            stringBuffer.append("If you want to know reason. You can contact with admin.");
            stringBuffer.append("\nThank you.\n");
            stringBuffer.append("TechRiders Team");
            mail.setText(stringBuffer.toString());
            javaMailSender.send(mail);

            return userService.declinedById(id);
        } catch (NoSuchElementException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }

    }

}
