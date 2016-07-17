package com.transport.email;

import com.transport.model.Order;

import javax.mail.MessagingException;

/**
 * Created by AK on 7/17/2016.
 */
public interface SmtpMailSender {
    void sent(Order order) throws MessagingException;
}
