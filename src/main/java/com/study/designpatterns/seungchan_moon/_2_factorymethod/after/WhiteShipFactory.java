package com.study.designpatterns.seungchan_moon._2_factorymethod.after;

public class WhiteShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
