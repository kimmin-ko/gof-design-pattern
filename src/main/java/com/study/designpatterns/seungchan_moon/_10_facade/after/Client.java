package com.study.designpatterns.seungchan_moon._10_facade.after;

public class Client {
    public static void main(String[] args) {
        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost("127.0.0.1");
        EmailSender emailSender = new EmailSender(emailSettings);
        EmailMessage emailMessage = new EmailMessage("m3252", "m3252", "오징어게임", "밖은 더 지옥이더라고..");
        emailSender.sendEmail(emailMessage);
    }
}
