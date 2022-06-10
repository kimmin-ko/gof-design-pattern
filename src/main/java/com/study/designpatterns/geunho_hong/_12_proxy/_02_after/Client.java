package com.study.designpatterns.geunho_hong._12_proxy._02_after;

public class Client {

    public static void main(String[] args) {
        GameService gameService = new GameServiceProxy();
        gameService.startGame();
    }
}
