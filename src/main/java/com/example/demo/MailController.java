package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {
    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/form")
    public String goToAddProductForm(Model model) {
        Mail mail = new Mail();
        model.addAttribute("mail", mail);
        return "form";
    }

    @PostMapping("/sendEmail")
    public String createEmail(Mail mail) {
        System.out.println(mail);
        mailService.acceptEmail(mail.getSender(), mail.getContent());
        mailService.sendConfirmation(mail.getEmailAddress());
        return "success";
    }
}
