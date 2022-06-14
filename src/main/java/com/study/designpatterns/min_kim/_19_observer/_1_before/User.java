package com.study.designpatterns.min_kim._19_observer._1_before;

public class User {

    private final ChatServer chatServer;

    public User(ChatServer chatServer) {
        this.chatServer = chatServer;
    }

    public void sendMessage(String subject, String message) {
        System.out.printf("subject: %s, message: %s", subject, message);
    }

    public String getMessage(String subject) {
        return "메세지";
    }
}
