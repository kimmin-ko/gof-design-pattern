package com.study.designpatterns.hyeongseok_choi._3_abstractfactory._02_after;


public class WhiteShipPartsFactory  implements ShipPartsFactory{
    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
