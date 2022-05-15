package com.study.designpatterns.seungchan_moon._12_proxy.after;

public class Client {
    public static void main(String[] args) {
        GameService gameService = new GameServiceProxy();
        gameService.start();
    }
}
