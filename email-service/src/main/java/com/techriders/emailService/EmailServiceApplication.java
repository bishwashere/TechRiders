package com.techriders.emailService;

import com.techriders.emailService.emailservice.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;
import java.util.Locale;

@SpringBootApplication
public class EmailServiceApplication {

    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(EmailServiceApplication.class, args);
    }

}
