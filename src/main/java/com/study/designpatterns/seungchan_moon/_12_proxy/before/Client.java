package com.study.designpatterns.seungchan_moon._12_proxy.before;

public class Client {
    public static void main(String[] args) {
        GameService gameService = new GameServiceProxy();
        gameService.start();
    }
}
