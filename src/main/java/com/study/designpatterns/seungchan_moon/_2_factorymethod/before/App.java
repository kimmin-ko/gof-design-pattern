package com.study.designpatterns.seungchan_moon._2_factorymethod.before;


public class App {
    public static void main(String[] args) {
        Client client = new Client();

        Ship whiteShip = ShipFactory.orderShip("WhiteShip", "@naver.com");
        System.out.println(whiteShip);
        Ship blackShip = ShipFactory.orderShip("blackShip", "@gmail.com");
        System.out.println(blackShip);
    }
}
