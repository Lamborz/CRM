package com.transport.email;

/**
 * Created by AK on 7/17/2016.
 */
public interface SmtpMailSender {
    void sent(String to, String subject, String body);
}
