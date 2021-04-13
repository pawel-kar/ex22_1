package com.example.demo;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;
    private static final String SERVICE_EMAIL_ADDRESS = "kontodoszkoleniajavy@gmail.com";
    private static final String SUBJECT = "FIRMA WIDELCZYK POTWIERDZENIE";
    private static final String CONFIRMATION_TEXT = "Otrzymaliśmy zapytanie, wkrótce odpowiemy na Waszego maila";

    public MailService(JavaMailSender mailSender) {
        this.javaMailSender = mailSender;
    }

    public void acceptEmail(String sender, String content, String emailAddress) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(SERVICE_EMAIL_ADDRESS);
            helper.setSubject("WYSYŁAJĄCY: " + sender);
            helper.setText(content, true);
            helper.setReplyTo(emailAddress);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.err.println("Błąd wysyłania wiadomośći");
        }
    }

    public void sendConfirmation(String emailAddress) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom(SERVICE_EMAIL_ADDRESS);
            helper.setTo(emailAddress);
            helper.setSubject(SUBJECT);
            helper.setText(CONFIRMATION_TEXT, true);
            helper.setReplyTo(SERVICE_EMAIL_ADDRESS);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.err.println("Błąd wysyłania wiadomośći");
        }
    }
}
