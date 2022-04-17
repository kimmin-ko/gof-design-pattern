package com.study.designpatterns.min_kim._2_factory_method._02_after;

public class Client {

    public static void main(String[] args) {
        Ship whiteship = new WhiteshipFactory().orderShip("whiteship", "min@mail.com");
        System.out.println("whiteship = " + whiteship);

        Ship blackship = new BlackshipFactory().orderShip("blackship", "min@mail.com");
        System.out.println("blackship = " + blackship);
    }

}
