package com.techriders.emailService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping(value = "/administration/users")
public class SampleEmailController {

    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping(value = "/accept/{id}")
    public @ResponseBody
    Boolean acceptUser(@PathVariable("id") long id) {
        try {

            SimpleMailMessage mail = new SimpleMailMessage();

            mail.setFrom("TechRiders");
            mail.setTo("srana@miu.edu");
            mail.setSubject("Account Activated");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Hi ");
            stringBuffer.append("Samsher");
            stringBuffer.append(",");
            stringBuffer.append("\n");
            stringBuffer.append("Your account is activated in TechRiders.\n");
            stringBuffer.append("Now you can login with your username and password.");
            stringBuffer.append("\nThank you.\n");
            stringBuffer.append("TechRiders Team");

            mail.setText(stringBuffer.toString());
            javaMailSender.send(mail);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

}
