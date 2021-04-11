package com.example.demo;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender mailSender) {
        this.javaMailSender = mailSender;
    }

    public void acceptEmail(String sender, String content) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo("kontodoszkoleniajavy@gmail.com");
            helper.setSubject("WYSYŁAJĄCY: " + sender);
            helper.setText(content, true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.err.println("Błąd wysyłania wiadomośći");
        }
    }

    public void sendConfirmation(String emailAddress) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom("kontodoszkoleniajavy@gmail.com");
            helper.setTo(emailAddress);
            helper.setSubject("FIRMA WIDELCZYK POTWIERDZENIE");
            helper.setText("Otrzymaliśmy zapytanie, wkrótce odpowiemy na Waszego maila", true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.err.println("Błąd wysyłania wiadomośći");
        }
    }
}
