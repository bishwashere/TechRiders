package com.techriders.emailService.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TestRunner implements CommandLineRunner {
    @Autowired
    private EmailService emailService;

    @Override
    public void run(String...args) throws Exception {
        emailService.sendEmail("Pradip", "youracharya@gmail.com",new Locale("en"));
        System.out.println("                  The Email is on the WAY!!!");

    }
}