package com.study.designpatterns.seungchan_moon._2_factorymethod.after;

public class App {
    public static void main(String[] args) {
        Client client = new Client();

        Ship whiteShip = new WhiteShipFactory().orderShip("whiteShip", "@naver.com");
        System.out.println(whiteShip);

        Ship blackShip = new BlackShipFactory().orderShip("blackShip", "@gmail.com");
        System.out.println(blackShip);
    }
}
