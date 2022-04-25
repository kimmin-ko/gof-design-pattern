package com.study.designpatterns.hyeongseok_choi._2_factorymethod._02_after;

public class WhiteShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }

}
