package com.techriders.emailService.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

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

    public void sendEmail(final String recipientName, final String recipientEmail, final Locale locale) throws MessagingException {
        // Prepare the Thymeleaf evaluation context
        final Context context = new Context(locale);
        context.setVariable("name", recipientName);

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setSubject("Sample Email");

        // could have CC, BCC, will also take an array of Strings
        message.setTo(recipientEmail);

        // Create the HTML body using Thymeleaf..template is sample.html
        final String htmlContent = this.templateEngine.process("user/email/sample-email", context);
        message.setText(htmlContent, true /* isHtml */);


        // Send email
        this.mailSender.send(mimeMessage);


    }

}
