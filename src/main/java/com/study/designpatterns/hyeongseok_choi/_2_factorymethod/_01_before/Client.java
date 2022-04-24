package com.study.designpatterns.hyeongseok_choi._2_factorymethod._01_before;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();

        Ship whiteShip = ShipFactory.orderShip("whiteship", "mail1@mail.com");
        System.out.println(whiteShip);

        Ship blackShip = ShipFactory.orderShip("blackship", "mail1@mail.com");
        System.out.println(blackShip);
    }
}
