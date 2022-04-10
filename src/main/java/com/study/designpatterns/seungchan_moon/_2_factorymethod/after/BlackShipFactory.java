package com.study.designpatterns.seungchan_moon._2_factorymethod.after;

public class BlackShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
