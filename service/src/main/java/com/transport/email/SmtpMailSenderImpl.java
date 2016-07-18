package com.transport.email;

import com.transport.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by AK on 7/16/2016.
 */
@Component
public class SmtpMailSenderImpl implements SmtpMailSender {

    @Autowired
    private JavaMailSenderImpl mailSender;

    private SimpleMailMessage templateMessage;
    @Override
    public void sent(Order order) throws MessagingException {;
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
//        mailMsg.setFrom("geniusessay@gmail.com");
        mailMsg.setTo(order.getClient().getMail());
        mailMsg.setSubject("Test mail2");
        mailMsg.setText("Hello World!");
        mailSender.send(mimeMessage);
        System.out.println("---Done---");


/*        mailSender = new JavaMailSenderImpl();
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
        }*/
    }

}
