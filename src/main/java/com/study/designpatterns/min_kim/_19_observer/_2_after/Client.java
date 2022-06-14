package com.study.designpatterns.min_kim._19_observer._2_after;

public class Client {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User user1 = new User("kim min");
        User user2 = new User("developer");

        String designPatternSubject = "design_pattern";

        chatServer.register(designPatternSubject, user1);
        chatServer.register(designPatternSubject, user2);

        chatServer.sendMessage(user1, designPatternSubject, "디자인 패턴 공부중11 !!");

        chatServer.unregister(designPatternSubject, user1);

        chatServer.sendMessage(user2, designPatternSubject, "디자인 패턴 공부중22 !!");
    }
}
