package com.study.designpatterns.min_kim._2_factorymethod._02_after;

public class WhiteshipFactory implements ShipFactory {

    @Override
    public Ship createShip(String name) {
        return new Whiteship(name);
    }
}
