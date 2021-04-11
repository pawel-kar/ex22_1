package com.example.demo;

public class Mail {
    private String sender;
    private String emailAddress;
    private String content;

    public Mail() {
    }

    public Mail(String sender, String emailAddress, String content) {
        this.sender = sender;
        this.emailAddress = emailAddress;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "sender='" + sender + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
