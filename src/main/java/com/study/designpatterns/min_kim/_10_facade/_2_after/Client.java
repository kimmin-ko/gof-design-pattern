package com.study.designpatterns.min_kim._10_facade._2_after;

public class Client {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        EmailSettings emailSettings = new EmailSettings(host);

        String from = "min@naver.com";
        String to = "kimmin@naver.com";
        String subject = "Test mail from java program";
        String text = "message";
        EmailMessage message = new EmailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        EmailSender emailSender = new EmailSender(emailSettings);
        emailSender.send(message);
    }
}