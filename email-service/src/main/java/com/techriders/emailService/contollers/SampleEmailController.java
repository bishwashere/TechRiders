package com.techriders.emailService.contollers;

import com.techriders.emailService.emailservice.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Locale;


//SAMPLE IT IS NEVER USED USED


@Controller
public class SampleEmailController {
    @Autowired
    EmailService emailService;
    @RequestMapping(value = "/sendMailWithInlineImage", method = RequestMethod.POST)
    public String sendMailWithInline(
            @RequestParam("recipientName") final String recipientName,
            @RequestParam("recipientEmail") final String recipientEmail,
            @RequestParam("image") final MultipartFile image,
            final Locale locale)
            throws MessagingException, IOException {

//        this..emailService(
//                recipientName, recipientEmail, image.getName(),
//                image.getBytes(), image.getContentType(), locale);
        return "redirect:XXX.html";

    }
}