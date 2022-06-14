package com.study.designpatterns.min_kim._19_observer._1_before;

public class Client {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        String designPattern = "디자인 패턴";
        String loldcup = "롤드컵 2021";

        User user1 = new User(chatServer);
        user1.sendMessage(designPattern, "이번엔 옵저버 패턴입니다.");
        user1.sendMessage(loldcup, "LCK 화이팅!");

        User user2 = new User(chatServer);
        System.out.println(user2.getMessage(designPattern));

        user1.sendMessage(designPattern, "예제 코드 보는중...");
        System.out.println(user2.getMessage(designPattern));
    }
}