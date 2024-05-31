package com.example.practice21.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
@Service
public class EmailService {
    @Async
    public void sendEmail(String method) {
        final String username = "roflandown@yandex.ru";
        final String password = "123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("roflandown@yandex.ru"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("ajant555@gmail.com"));
            message.setSubject("Действие с базой данных");
            message.setText(method);

            Transport.send(message);

            System.out.println("Письмо отправлено!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
