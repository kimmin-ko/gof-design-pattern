package com.study.designpatterns.min_kim._2_factorymethod._01_before;

public class Client {

    public static void main(String[] args) {
        Ship whiteship = ShipFactory.orderShip("whiteship", "min@mail.com");
        System.out.println("whiteship = " + whiteship);

        Ship blackship = ShipFactory.orderShip("blackship", "min@mail.com");
        System.out.println("blackship = " + blackship);
    }

}
