package com.transport.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * Created by AK on 7/16/2016.
 */
@Component
public class SmtpMailSenderImpl implements SmtpMailSender {

    private JavaMailSender mailSender;
    private SimpleMailMessage templateMessage;
    @Override
    public void sent(String to, String subject, String body)  {
        mailSender = new JavaMailSenderImpl();
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setSubject(subject);
            helper.setTo(to);
            helper.setText(body, true);
            mailSender.send(message);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }

}
