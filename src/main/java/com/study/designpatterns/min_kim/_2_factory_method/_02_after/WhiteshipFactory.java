package com.study.designpatterns.min_kim._2_factory_method._02_after;

public class WhiteshipFactory implements ShipFactory {

    @Override
    public Ship createShip(String name) {
        return new Whiteship(name);
    }
}
