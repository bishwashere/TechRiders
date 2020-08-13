package com.techriders.emailService.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Locale;

@Service("emailService")
public class EmailService {
//
//    private static final String IM_THE_GUY = "templates/images/imtheguy.jpg";
//
//    private static final String JPG_MIME = "image/jpg";
//    private static final String DOCX_MIME = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    /*
     * Send HTML mail
     */

    public void sendEmail(String messageJSON) throws MessagingException, JsonMappingException, JsonProcessingException {
    	
    	ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(messageJSON);
        
        
        String recipientName = actualObj.get("name").asText();
        String recipientEmail = actualObj.get("email").asText();
        String transactionId = actualObj.get("transactionId").asText();
        String billingAddress = actualObj.get("billingAddress").asText();
        String shippingAddress = actualObj.get("shippingAddress").asText();
        String status = actualObj.get("orderStatus").asText();
        if(status.equals("ON_THE_WAY")) status="ON THE WAY";


        // Prepare the Thymeleaf evaluation context
        Locale locale = new Locale("en");
        final Context context = new Context(locale);
        context.setVariable("name", recipientName);
        context.setVariable("transactionId", transactionId);
        context.setVariable("billingAddress", billingAddress);
        context.setVariable("shippingAddress", shippingAddress);
        context.setVariable("status", status);



        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setSubject(status+" - Tech Riders Order Details!!!");

        // could have CC, BCC, will also take an array of Strings
        message.setTo(recipientEmail);

        // Create the HTML body using Thymeleaf..template is sample.html
        final String htmlContent = this.templateEngine.process("user/email/order-email", context);
        //final String htmlContent = messageContent;

        message.setText(htmlContent, true /* isHtml */);


        // Send email
        this.mailSender.send(mimeMessage);


    }

}
